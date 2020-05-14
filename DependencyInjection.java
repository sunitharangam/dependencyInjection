package com.depinject.framework;

import com.depinject.framework.service.DependencyInjectionMapping;

public final class DependencyInjection {
	private DependencyInjection() {
		
	}
	
    public static DependencyInjectionFramework getFramework(final DependencyInjectionMapping dependencyInjectionMapping) {
    	dependencyInjectionMapping.configure();
        return new DependencyInjectionFramework(dependencyInjectionMapping);
    }
}
