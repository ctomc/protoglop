/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2011, Red Hat, Inc., and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package example1;

import java.util.List;
import java.util.Map;
import org.jboss.mgmt.Resource;
import org.jboss.mgmt.annotation.Attribute;
import org.jboss.mgmt.annotation.RootResource;
import org.jboss.mgmt.annotation.SubResource;

/**
 * @author <a href="mailto:david.lloyd@redhat.com">David M. Lloyd</a>
 */
@RootResource(
    type = "top",
    namespace = "jboss",
    version = "1.0",
    kind = RootResource.Kind.SYSTEM,
    compatibilityNamespaces = { "urn:jboss:domain:1.0" }
)
public interface DomainResource extends Resource {

    @Attribute
    Map<String, BootTimePropertyType> getProperties();

    @SubResource
    List<String> getPathNames();

    PathResource getPath(String name);

    @SubResource
    List<String> getProfileNames();

    ProfileResource getProfile(String name);

    @SubResource
    List<String> getInterfaceNames();

    // InterfaceResource getInterface(String name);

    @SubResource
    List<String> getSocketBindingGroupNames();

    // SocketBindingGroupResource getSocketBindingGroup(String name);

    @SubResource
    List<String> getDeploymentNames();

    // DomainDeployment getDeployment(String name);

    @SubResource
    List<String> getServerGroupNames();

    // ServerGroup getServerGroup(String name);

    @SubResource
    List<String> getManagementClientContextNames();

    // ManagementClientContext getManagementClientContext(String name);

    @SubResource
    List<String> getJvmNames();

    // Jvm getJvm(String name);

    @SubResource
    List<String> getServers();

    DomainServerResource getServer(String name);
}
