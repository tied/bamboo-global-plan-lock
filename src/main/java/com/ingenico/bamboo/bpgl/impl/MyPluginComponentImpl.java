package com.ingenico.bamboo.bpgl.impl;

import javax.inject.Inject;
import javax.inject.Named;

import com.atlassian.plugin.spring.scanner.annotation.export.ExportAsService;
import com.atlassian.plugin.spring.scanner.annotation.imports.ComponentImport;
import com.atlassian.sal.api.ApplicationProperties;
import com.ingenico.bamboo.bpgl.api.MyPluginComponent;

@ExportAsService({ MyPluginComponent.class })
@Named("GlobalPlanLockPluginComponent")
public class MyPluginComponentImpl implements MyPluginComponent {
	@ComponentImport
	private final ApplicationProperties applicationProperties;

	@Inject
	public MyPluginComponentImpl(final ApplicationProperties applicationProperties) {
		this.applicationProperties = applicationProperties;
	}

	public String getName() {
		if (null != applicationProperties) {
			return "myComponent:" + applicationProperties.getDisplayName();
		}

		return "myComponent";
	}
}