package com.apt;

import com.apt.processors.InstanceProcessor;
import com.google.auto.service.AutoService;

import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;

/**
 * -------------------------------------
 * <p>
 * 项目名称： FirstLineCode
 * <p>
 * 版权：locensate.com 版权所有 2016
 * <p>
 * 公司主页：http://www.locensate.com/
 * <p>
 * 描述：
 * <p>
 * 作者： xiaobinghe
 * <p>
 * 时间： 2017/7/14 11:52
 * <p>
 * 修改历史：
 * <p>
 * 修改时间：
 * <p>
 * 修改描述：
 * <p>
 * -------------------------------------
 */

@AutoService(Processor.class)
@SupportedSourceVersion(SourceVersion.RELEASE_7)
@SupportedAnnotationTypes({"com.apt.InstanceFactory"})
public class AnnotationProcessor extends AbstractProcessor {

    public Filer mFiler;
    public Messager mMessager;
    public Elements mElementUtils;

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        mFiler = processingEnv.getFiler();
        mMessager = processingEnv.getMessager();
        mElementUtils = processingEnv.getElementUtils();
        new InstanceProcessor().process(roundEnv, this);
        return true;
    }
}
