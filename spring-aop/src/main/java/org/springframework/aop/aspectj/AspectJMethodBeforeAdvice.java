/*
 * Copyright 2002-2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.aop.aspectj;

import java.io.Serializable;
import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.lang.Nullable;

/**
 * Spring AOP advice that wraps an AspectJ before method.
 *
 * @author Rod Johnson
 * @author Adrian Colyer
 * @since 2.0
 */
@SuppressWarnings("serial")
public class AspectJMethodBeforeAdvice extends AbstractAspectJAdvice implements MethodBeforeAdvice, Serializable {

	/**
	 * aspectJBeforeAdviceMethod: advice 方法
	 * pointcut: 切点, 一般是一个表达式
	 * aspectInstanceFactory: 创建 aspect 实例的工厂
	 */
	public AspectJMethodBeforeAdvice(
			Method aspectJBeforeAdviceMethod,
			AspectJExpressionPointcut pointcut,
			AspectInstanceFactory aspectInstanceFactory) {

		super(aspectJBeforeAdviceMethod, pointcut, aspectInstanceFactory);
	}


	@Override
	public void before(Method method, Object[] args, @Nullable Object target) throws Throwable {
		invokeAdviceMethod(getJoinPointMatch(), null, null);
	}

	@Override
	public boolean isBeforeAdvice() {
		return true;
	}

	@Override
	public boolean isAfterAdvice() {
		return false;
	}

}
