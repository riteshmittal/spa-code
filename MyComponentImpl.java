package com.adobe.aem.guides.wknd.spa.react.core.models.impl;

import org.apache.sling.models.annotations.*;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import com.adobe.aem.guides.wknd.spa.react.core.models.MyComponent;
import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;

@Model(adaptables = SlingHttpServletRequest.class, adapters = { MyComponent.class,
		ComponentExporter.class }, resourceType = MyComponentImpl.RESOURCE_TYPE, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class MyComponentImpl implements MyComponent {

	@ValueMapValue
	private String text;

	static final String RESOURCE_TYPE = "wknd-spa-react/components/my-component";

	@Override
	public String getText() {
		return StringUtils.isNotBlank(text) ? text.toUpperCase() : null;
	}

	public String getMyNewProperty() {
		return "My new property";
	}
	
	@Override
	public String getExportedType() {
		return MyComponentImpl.RESOURCE_TYPE;
	}

}