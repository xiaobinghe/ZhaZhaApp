package com.apt.inter;

import com.apt.AnnotationProcessor;

import javax.annotation.processing.RoundEnvironment;


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
 * @author xiaobinghe
 */


public interface IProcessor {
    /**
     * 进程
     *
     * @param roundEnvironment
     * @param processor
     */
    void process(RoundEnvironment roundEnvironment, AnnotationProcessor processor);
}
