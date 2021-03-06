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

package org.jboss.mgmt.annotation;

/**
 * A reference to a nested resource.
 *
 * @author <a href="mailto:david.lloyd@redhat.com">David M. Lloyd</a>
 */
public @interface SubResource {

    /**
     * Specify a type for the sub-resource.  This allows root resources to be used.  If not given,
     * the return type will be inspected to see if it is a typed sub-resource.
     *
     * @return
     */
    String type() default "";

    /**
     * The name in the model.
     *
     * @return the name name
     */
    String name() default "";

    /**
     * Requires a unique value for "provides" values.
     *
     * @return {@code true} to enforce uniqueness, {@code false} to ignore "provides" values
     */
    boolean requiresUniqueProvider() default false;

    /**
     * Get the non-root child resources for this sub-resource, if any.  If none are given, only
     * root resources can satisfy this link.
     *
     * @return the non-root children
     */
    Class<?>[] children() default {};
}
