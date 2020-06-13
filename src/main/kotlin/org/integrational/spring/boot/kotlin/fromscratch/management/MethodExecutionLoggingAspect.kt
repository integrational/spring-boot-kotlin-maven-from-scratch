package org.integrational.spring.boot.kotlin.fromscratch.management

import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.Signature
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Pointcut
import org.aspectj.lang.reflect.MethodSignature
import org.integrational.spring.boot.kotlin.profile.NonProduction
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Aspect
@Component
@NonProduction
class MethodExecutionLoggingAspect {

    @Pointcut("execution(* org.integrational..*.*(..))")
    private fun anyIntegrationalMethod() {
    }

    @Around("anyIntegrationalMethod()")
    fun logExecution(pjp: ProceedingJoinPoint): Any? {
        val log = LoggerFactory.getLogger(pjp.target.javaClass)
        val met = pjp.signature.name
        logEnter(log, pjp, met)
        try {
            return pjp.proceed(pjp.args).also { logReturn(log, pjp, met, it) }
        } catch (t: Throwable) {
            throw t.also { logThrow(log, met, t) }
        }
    }

    private fun logEnter(l: Logger, p: ProceedingJoinPoint, m: String?) =
        if (p.args.isEmpty()) l.debug("Enter  {}()", m)
        else l.debug("Enter  {}{}", m, p.args)

    private fun logReturn(l: Logger, p: ProceedingJoinPoint, m: String?, r: Any?) =
        if (isNotVoid(p.signature)) l.debug("Return {}(): {}", m, r)
        else l.debug("Return {}()", m)

    private fun logThrow(l: Logger, m: String?, t: Throwable) =
        l.debug("Throw  {}(): {}", m, t.toString())

    private fun isNotVoid(s: Signature?) = s is MethodSignature && s.returnType != Void.TYPE
}