/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2012, Red Hat, Inc., and individual contributors
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

package org.jboss.mgmt.generator;

import org.jboss.mgmt.annotation.RootResource;

import javax.lang.model.type.DeclaredType;

/**
 * @author <a href="mailto:david.lloyd@redhat.com">David M. Lloyd</a>
 */
final class RootResourceBuilderImpl extends GeneralResourceBuilderImpl<RootResourceBuilderImpl> implements RootResourceBuilder {
    private final Session session;
    private String namespace;
    private String version = "1.0";
    private String schemaLocation;
    private RootResource.Kind kind = RootResource.Kind.EXTENSION;

    RootResourceBuilderImpl(final Session session, final String type, final DeclaredType resourceInterface) {
        super(type, resourceInterface);
        this.session = session;
    }

    public RootResourceBuilder schemaLocation(final String schemaLocation) {
        this.schemaLocation = schemaLocation;
        return this;
    }

    public RootResourceBuilder version(final String version) {
        this.version = version;
        return this;
    }

    public RootResourceBuilder kind(final RootResource.Kind kind) {
        this.kind = kind;
        return this;
    }

    public RootResourceBuilder namespace(final String namespace) {
        this.namespace = namespace;
        return this;
    }

    public Session end() {
        return session;
    }

    String getNamespace() {
        return namespace;
    }

    String getVersion() {
        return version;
    }

    String getSchemaLocation() {
        return schemaLocation;
    }

    RootResource.Kind getKind() {
        return kind;
    }
}
