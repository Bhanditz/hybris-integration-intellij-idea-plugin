/*
 * This file is part of "hybris integration" plugin for Intellij IDEA.
 * Copyright (C) 2014-2016 Alexander Bartash <AlexanderBartash@gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package com.intellij.idea.plugin.hybris.common;

import com.intellij.util.containers.ContainerUtil;

import java.util.List;

import static com.intellij.openapi.util.io.FileUtilRt.toSystemDependentName;


/**
 * Created 10:30 PM 07 June 2015
 *
 * @author Alexander Bartash <AlexanderBartash@gmail.com>
 */
public interface HybrisConstants {

    String EXTENSION_INFO_XML = "extensioninfo.xml";
    String DOT_PROJECT = ".project";
    String SETTINGS_GRADLE = "settings.gradle";
    String BUILD_GRADLE = "build.gradle";
    String LOCAL_EXTENSIONS_XML = "localextensions.xml";
    String PLATFORM_MODULE_PREFIX = toSystemDependentName("/bin/platform/");
    String HYBRIS_SERVER_SHELL_SCRIPT_NAME = toSystemDependentName("bin/platform/hybrisserver.sh");
    String PLATFORM_EXT_MODULE_PREFIX = toSystemDependentName("bin/platform/ext/");
    String PLATFORM_OOTB_MODULE_PREFIX = toSystemDependentName("bin/ext-");
    String HYBRIS_OOTB_MODULE_PREFIX = toSystemDependentName("hybris/") + PLATFORM_OOTB_MODULE_PREFIX;
    String HYBRIS_DATA_DIRECTORY = "data";

    String EXCLUDE_TMP_DIRECTORY = toSystemDependentName("/platform/tmp");
    String EXCLUDE_TCSERVER_DIRECTORY = toSystemDependentName("/platform/tcServer");
    String EXCLUDE_TOMCAT_DIRECTORY = toSystemDependentName("/platform/tomcat");
    String EXCLUDE_LIB_DIRECTORY = toSystemDependentName("/platform/lib");
    String EXCLUDE_RESOURCES_DIRECTORY = toSystemDependentName("/platform/resources");
    String EXCLUDE_ECLIPSEBIN_DIRECTORY = toSystemDependentName("/platform/eclipsebin");
    String EXCLUDE_BOOTSTRAP_DIRECTORY = toSystemDependentName("/platform/bootstrap");
    String EXCLUDE_ANT_DIRECTORY = toSystemDependentName("/platform/apache-ant-");
    String EXCLUDE_IDEA_MODULE_FILES_DIRECTORY = toSystemDependentName("/idea-module-files");
    String EXCLUDE_LOG_DIRECTORY = toSystemDependentName("/log");
    String EXCLUDE_DATA_DIRECTORY = toSystemDependentName("/data");
    String EXCLUDE_SVN_DIRECTORY = toSystemDependentName("/.svn");
    String EXCLUDE_GIT_DIRECTORY = toSystemDependentName("/.git");
    String EXCLUDE_TEMP_DIRECTORY = toSystemDependentName("/temp");
    String EXCLUDE_IDEA_DIRECTORY = toSystemDependentName("/.idea");
    String EXCLUDE_MACOSX_DIRECTORY = toSystemDependentName("/__MACOSX");
    String CUSTOM_MODULES_DIRECTORY_RELATIVE_PATH = toSystemDependentName("bin/custom");
    String EXTENSIONS_XML = "extensions.xml";
    String NEW_IDEA_MODULE_FILE_EXTENSION = ".iml";
    String PLATFORM_EXTENSION_NAME = "platform";
    String PLATFORM_DB_DRIVER = toSystemDependentName("lib/dbdriver");
    String CORE_EXTENSION_NAME = "core";
    String BACK_OFFICE_EXTENSION_NAME = "backoffice";
    String BACK_OFFICE_MODULE_META_KEY_NAME = "backoffice-module";
    String HAC_MODULE_META_KEY_NAME = "hac-module";
    String HMC_EXTENSION_NAME = "hmc";
    String PLATFORM_EXTENSIONS_DIRECTORY_NAME = "ext";
    String CONFIG_EXTENSION_NAME = "config";
    String ACCELERATOR_STOREFRONT_COMMONS_EXTENSION_NAME = "acceleratorstorefrontcommons";
    String CONFIG_RELATIVE_PATH = toSystemDependentName("/../../" + CONFIG_EXTENSION_NAME);
    String LIB_DIRECTORY = "lib";
    String BIN_DIRECTORY = "bin";
    String RESOURCES_DIRECTORY = "resources";
    String LOCAL_PROPERTIES = "local.properties";
    String PROJECT_PROPERTIES = "project.properties";
    String ADVANCED_PROPERTIES = toSystemDependentName(RESOURCES_DIRECTORY + "/advanced.properties");
    String APPLICATION_CONTEXT_SPRING_FILES = "application-context";
    String ADDITIONAL_WEB_SPRING_CONFIG_FILES = "additionalWebSpringConfigs";
    String GLOBAL_CONTEXT_SPRING_FILES = "global-context";
    String HYBRIS_CONFIG_DIR_KEY = "HYBRIS_CONFIG_DIR";
    String PLATFORM_HOME_PLACEHOLDER = "${platformhome}";
    String BUILD_NUMBER_FILE_PATH = toSystemDependentName("/bin/platform/build.number");
    String HYBRIS_API_VERSION_KEY = "version.api";
    String DEFAULT_JAVADOC_ROOT_URL = "https://download.hybris.com/api/%s/commercesuite";
    String HYBRIS_6_0_PLUS_JAVADOC_ROOT_URL = "https://help.hybris.com/%s/api/commercesuite/index.html";

    String SRC_DIRECTORY = "src";
    String GEN_SRC_DIRECTORY = "gensrc";
    String TEST_SRC_DIRECTORY = "testsrc";
    String GROOVY_TEST_SRC_DIRECTORY = "groovytestsrc";
    List<String> TEST_SRC_DIR_NAMES = ContainerUtil.immutableList(TEST_SRC_DIRECTORY, GROOVY_TEST_SRC_DIRECTORY);
    String HMC_MODULE_DIRECTORY = "hmc";
    String HAC_MODULE_DIRECTORY = "hac";
    String HAC_MODULE_EXTENSION_NAME = "hac";
    String WEB_MODULE_DIRECTORY = "web";
    String BACK_OFFICE_MODULE_DIRECTORY = "backoffice";
    String ADDON_SRC_DIRECTORY = "addonsrc";
    String TEST_CLASSES_DIRECTORY = "testclasses";
    String CLASSES_DIRECTORY = "classes";
    String SETTINGS_DIRECTORY = ".settings";
    String EXTERNAL_TOOL_BUILDERS_DIRECTORY = ".externalToolBuilders";
    String WEB_ROOT_DIRECTORY = "webroot";
    String WEB_ROOT_DIRECTORY_RELATIVE_PATH = toSystemDependentName(WEB_MODULE_DIRECTORY + '/' + WEB_ROOT_DIRECTORY);
    String WEB_INF_DIRECTORY = "WEB-INF";
    String WEB_INF_DIRECTORY_RELATIVE_PATH = toSystemDependentName(WEB_ROOT_DIRECTORY_RELATIVE_PATH + '/' + WEB_INF_DIRECTORY);
    String WEB_XML_FILE_NAME = "web.xml";
    String WEB_XML_DIRECTORY_RELATIVE_PATH = toSystemDependentName(WEB_INF_DIRECTORY_RELATIVE_PATH + '/' + WEB_XML_FILE_NAME);
    String COMMON_WEB_SRC_DIRECTORY = "commonwebsrc";
    String COMMON_WEB_MODULE_DIRECTORY = "commonweb";
    String ACCELERATOR_ADDON_DIRECTORY = "acceleratoraddon";
    String PLATFORM_BOOTSTRAP_DIRECTORY = "bootstrap";
    String PLATFORM_MODEL_CLASSES_DIRECTORY = "modelclasses";
    String PLATFORM_TOMCAT_DIRECTORY = "tomcat";
    String PLATFORM_TOMCAT_WORK_DIRECTORY = "work";
    String NODE_MODULES_DIRECTORY = "node_modules";
    String JS_TARGET_DIRECTORY = "jsTarget";
    String BOWER_COMPONENTS_DIRECTORY = "bower_components";

    String PLATFORM_LIBRARY_GROUP = "Platform Bootstrap";
    String BACKOFFICE_LIBRARY_GROUP = "Backoffice Library";

    String WEBINF_LIB_DIRECTORY = toSystemDependentName("webroot/WEB-INF/lib");
    String WEB_WEBINF_LIB_DIRECTORY = toSystemDependentName(WEB_MODULE_DIRECTORY + '/' + WEBINF_LIB_DIRECTORY);
    String COMMONWEB_WEBINF_LIB_DIRECTORY = toSystemDependentName(COMMON_WEB_MODULE_DIRECTORY + '/' + WEBINF_LIB_DIRECTORY);
    String WEB_INF_CLASSES_DIRECTORY = toSystemDependentName(WEB_MODULE_DIRECTORY + '/' + "webroot/WEB-INF/classes");
    String WEB_SRC_DIRECTORY = toSystemDependentName("web/src");
    String HMC_LIB_DIRECTORY = toSystemDependentName("hmc/bin");
    String BACKOFFICE_LIB_DIRECTORY = toSystemDependentName("backoffice/bin");
    String BACKOFFICE_JAR_DIRECTORY = toSystemDependentName("resources/backoffice");

    String PL_BOOTSTRAP_LIB_DIRECTORY = toSystemDependentName("bootstrap/bin");
    String PL_BOOTSTRAP_GEN_SRC_DIRECTORY = toSystemDependentName("bootstrap/gensrc");
    String PL_TOMCAT_LIB_DIRECTORY = toSystemDependentName("tomcat/lib");
    String PL_TOMCAT_BIN_DIRECTORY = toSystemDependentName("tomcat/bin");

    String CONFIG_LICENCE_DIRECTORY = "licence";

    String ECLIPSE_BIN_DIRECTORY = "eclipsebin";
    String WEB_COMPILER_OUTPUT_PATH = WEB_INF_CLASSES_DIRECTORY;
    String WEB_COMPILER_FAKE_OUTPUT_PATH = toSystemDependentName("web/webroot/WEB-INF/eclipsebin");
    String BACKOFFICE_COMPILER_OUTPUT_PATH = toSystemDependentName("/backoffice/classes");
    String BACKOFFICE_COMPILER_FAKE_OUTPUT_PATH = toSystemDependentName("/backoffice/eclipsebin");
    String JAVA_COMPILER_OUTPUT_PATH = toSystemDependentName("/classes");
    String JAVA_COMPILER_FAKE_OUTPUT_PATH = ECLIPSE_BIN_DIRECTORY;

    String HYBRIS_PROJECT_SETTINGS_FILE_NAME = "hybrisProjectSettings.xml";
    String HYBRIS_PROJECT_SETTINGS_COMPONENT_NAME = "HybrisProjectSettings";
    String HYBRIS_INTEGRATION_SETTINGS_FILE_NAME = "hybrisIntegrationSettings.xml";

    String DEFAULT_DIRECTORY_NAME_FOR_IDEA_MODULE_FILES = "idea-module-files";
    String PLUGIN_ID = "ccom.intellij.idea.plugin.hybris.impex";
    String JREBEL_PLUGIN_ID = "JRebelPlugin";
    String CONFIGURATOR_FACTORY_ID = PLUGIN_ID + ".hybrisConfiguratorFactory";

    String HYBRIS_ITEMS_XML_FILE_ENDING = "-items.xml";
    String HYBRIS_BEANS_XML_FILE_ENDING = "-beans.xml";
    String RULESET_XML = "ruleset.xml";

    String HMC_WEB_INF_CLASSES = toSystemDependentName("/bin/ext-platform-optional/hmc/web/webroot/WEB-INF/classes");
    String BACKOFFICE_WEB_INF_LIB = toSystemDependentName("/bin/ext-backoffice/backoffice/web/webroot/WEB-INF/lib");
    String BACKOFFICE_WEB_INF_CLASSES = toSystemDependentName("/bin/ext-backoffice/backoffice/web/webroot/WEB-INF/classes");
    String HAC_WEB_INF_CLASSES = toSystemDependentName("/bin/platform/ext/hac/web/webroot/WEB-INF/classes");

    String DESCRIPTOR_TYPE = "descriptorType";
    String READ_ONLY = "importedAsReadOnly";

    String DEBUG_PORT = "8000";
    String TOMCAT_JAVA_DEBUG_OPTIONS = "tomcat.debugjavaoptions";
    String X_RUNJDWP_TRANSPORT = "-Xrunjdwp:transport=";
    String ADDRESS = "address=";
    String ANT_ENCODING = "-Dfile.encoding=UTF-8";
    String ANT_HYBRIS_CONFIG_DIR = "-J-DHYBRIS_CONFIG_DIR=";
    String ANT_XMX = "-Xmx";
    String ANT_PLATFORM_HOME = "PLATFORM_HOME";
    String ANT_OPTS = "ANT_OPTS";
    String ANT_HOME = "ANT_HOME";
    String ANT_COMPILING_XML = "resources/ant/compiling.xml";
    String ANT_DIR = "resources/ant";
    String ANT_LIB_DIR = ANT_DIR + "/lib";
    String ANT_BUILD_XML = "build.xml";
    int ANT_HEAP_SIZE_MB = 512;
    int ANT_STACK_SIZE_MB = 128;
    String STATS_COLLECTOR_URL = "http://intellij.bcom.cz/hybrisintegration";
    String SEARCH_SCOPE_Y_PREFIX = "[y]";
    String SEARCH_SCOPE_GROUP_PREFIX = "group:";
}
