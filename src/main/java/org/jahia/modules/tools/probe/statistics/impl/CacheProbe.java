/**
 * ==========================================================================================
 * =                   JAHIA'S DUAL LICENSING - IMPORTANT INFORMATION                       =
 * ==========================================================================================
 *
 *                                 http://www.jahia.com
 *
 *     Copyright (C) 2002-2018 Jahia Solutions Group SA. All rights reserved.
 *
 *     THIS FILE IS AVAILABLE UNDER TWO DIFFERENT LICENSES:
 *     1/GPL OR 2/JSEL
 *
 *     1/ GPL
 *     ==================================================================================
 *
 *     IF YOU DECIDE TO CHOOSE THE GPL LICENSE, YOU MUST COMPLY WITH THE FOLLOWING TERMS:
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program. If not, see <http://www.gnu.org/licenses/>.
 *
 *
 *     2/ JSEL - Commercial and Supported Versions of the program
 *     ===================================================================================
 *
 *     IF YOU DECIDE TO CHOOSE THE JSEL LICENSE, YOU MUST COMPLY WITH THE FOLLOWING TERMS:
 *
 *     Alternatively, commercial and supported versions of the program - also known as
 *     Enterprise Distributions - must be used in accordance with the terms and conditions
 *     contained in a separate written agreement between you and Jahia Solutions Group SA.
 *
 *     If you are unsure which license is appropriate for your use,
 *     please contact the sales department at sales@jahia.com.
 */
package org.jahia.modules.tools.probe.statistics.impl;

import java.io.PrintWriter;

import org.jahia.bin.Jahia;
import org.jahia.bin.errors.ErrorFileDumper;
import org.jahia.modules.tools.probe.Probe;
import org.jahia.modules.tools.probe.properties.impl.BaseSysInfoProbe;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;

/**
 * Reports current DX cache status.
 * 
 * @author Sergiy Shyrkov
 */
@Component(service = Probe.class, property = { Probe.KEY + "=" + CacheProbe.KEY,
        Constants.SERVICE_DESCRIPTION + "=" + CacheProbe.NAME, Probe.CATEGORY + "=" + CacheProbe.CATEGORY,
        Constants.SERVICE_VENDOR + "=" + Jahia.VENDOR_NAME,
        "jmx.objectname=org.jahia.server:type=tools,subtype=probe,category=" + CacheProbe.CATEGORY + ",name="
                + CacheProbe.KEY })
public class CacheProbe extends BaseSysInfoProbe {

    static final String CATEGORY = "statistics";

    static final String KEY = "cache";

    static final String NAME = "Cache status";

    @Override
    public void generateInfo(PrintWriter pw) {
        ErrorFileDumper.outputSystemInfo(pw, false, false, false, false, true, false, false, false);
    }

    @Override
    public String getCategory() {
        return CATEGORY;
    }

    @Override
    public String getKey() {
        return KEY;
    }

    @Override
    public String getName() {
        return NAME;
    }

}
