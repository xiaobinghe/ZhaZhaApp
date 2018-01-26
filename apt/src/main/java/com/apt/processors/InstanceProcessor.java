package com.apt.processors;

import com.apt.AnnotationProcessor;
import com.apt.InstanceFactory;
import com.apt.inter.IProcessor;
import com.apt.utils.Utils;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.CodeBlock;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.processing.FilerException;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.ElementFilter;
import javax.tools.Diagnostic;

import static com.squareup.javapoet.TypeSpec.classBuilder;
import static javax.lang.model.element.Modifier.FINAL;
import static javax.lang.model.element.Modifier.PUBLIC;
import static javax.lang.model.element.Modifier.STATIC;

/**
 * -------------------------------------
 * <p>
 * 项目名称： LetNetwork
 * </p>
 * 版权：locensate.com 版权所有 2017
 * <p>
 * 公司主页：http://www.locensate.com/
 * </p>
 * 描述：
 * <p>
 * 时间：
 * </p>
 * 修改历史：
 * <p>
 * 修改时间：
 * </p>
 * 修改描述：
 * <p>
 * -------------------------------------
 *
 * @author xiaobinghe
 */

public class InstanceProcessor implements IProcessor {


    @Override
    public void process(RoundEnvironment roundEnv, AnnotationProcessor processor) {
        String CLASS_NAME = "InstanceFactory";
        String METHOD_NAME = "create";
        TypeSpec.Builder tb = classBuilder(CLASS_NAME).addModifiers(PUBLIC,FINAL).addJavadoc("@ 实例工厂-APT自动生成");
        MethodSpec.Builder mb = MethodSpec.methodBuilder(METHOD_NAME)
                .addJavadoc("@此方法由apt自动生成")
                .returns(Object.class)
                .addModifiers(PUBLIC, STATIC)
                .addException(IllegalAccessException.class)
                .addException(InstantiationException.class)
                .addParameter(Class.class, "mClass");

        List<ClassName> mList = new ArrayList<>();
        CodeBlock.Builder cb = CodeBlock.builder();
        cb.beginControlFlow("switch(mClass.getSimpleName)");
        try {
            for (TypeElement element : ElementFilter.typesIn(roundEnv.getElementsAnnotatedWith(InstanceFactory.class))) {
                processor.mMessager.printMessage(Diagnostic.Kind.NOTE, "正在处理: " + element.toString());
                if (!Utils.isValidClass(processor.mMessager, element)) return;
                ClassName currentType = ClassName.get(element);
                if (mList.contains(currentType)) continue;
                mList.add(currentType);
                //             String className = null;
//                try {
//                    Class<?> clazz = element.getAnnotation(InstanceFactory.class).value();
//                    className = clazz.getCanonicalName();
//                } catch (MirroredTypeException mte) {
//                    DeclaredType classTypeMirror = (DeclaredType) mte.getTypeMirror();
//                    TypeElement classTypeElement = (TypeElement) classTypeMirror.asElement();
//                    className = classTypeElement.getQualifiedName().toString();
//                } catch (Exception e) {
//                }
//                if (className != null && !className.equals(InstanceFactory.class.getName())) {
//                    cb.addStatement("case $S: return  new $T()", currentType.simpleName(), Utils.getType(className));//初始化Repository
//                } else {
                cb.addStatement("case $S: return  new $T()", currentType.simpleName(), currentType);//初始化Presenter
                //               }
            }
            cb.addStatement("default: return mClass.newInstance()");
            cb.endControlFlow();
            mb.addCode(cb.build());
            tb.addMethod(mb.build());
            JavaFile javaFile = JavaFile.builder(Utils.PackageName, tb.build()).build();
            javaFile.writeTo(processor.mFiler);// 在 app module/build/generated/source/apt 生成一份源代码
        } catch (FilerException e) {
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
