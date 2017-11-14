/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package com.lofidewanto.demo.server;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.google.gwt.logging.server.RemoteLoggingServiceImpl;
import com.lofidewanto.demo.shared.DemoGwtServiceEndpoint;

@SpringBootApplication
public class DemoGwtSpringbootApplication {

	@Value("${server.context-path}")
	private String serverContextPath;

	public static void main(String[] args) {
		SpringApplication.run(DemoGwtSpringbootApplication.class, args);
	}

	@Bean
	public ServletRegistrationBean servletRegistrationBean() {
		return new ServletRegistrationBean(new RemoteLoggingServiceImpl(),
				serverContextPath + DemoGwtServiceEndpoint.GWT_REMOTE_LOGGING
						+ "/*");
	}
}
