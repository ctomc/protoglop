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

package org.jboss.mgmt;

/**
 * @author <a href="mailto:david.lloyd@redhat.com">David M. Lloyd</a>
 */
public abstract class AbstractResource implements Resource {
    private final String preComment;
    private final String postComment;
    private final String name;
    private final Resource parent;

    protected AbstractResource(final String preComment, final String postComment, final String name, final Resource parent) {
        this.preComment = preComment;
        this.postComment = postComment;
        this.name = name;
        this.parent = parent;
    }

    public String getPreComment() {
        return preComment;
    }

    public String getPostComment() {
        return postComment;
    }

    public String getName() {
        return name;
    }

    public Resource getParent() {
        return parent;
    }

    protected static IllegalArgumentException notReadable() {
        throw new IllegalArgumentException("This attribute is not readable");
    }
}
