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

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Infrastructure class used by generated resource implementations.
 *
 * @author <a href="mailto:david.lloyd@redhat.com">David M. Lloyd</a>
 */
public abstract class AbstractResourceBuilder<R extends Resource, P extends NestedBuilder<?>, THIS extends AbstractResourceBuilder<R, P, THIS>> implements NestedBuilder<P> {
    protected abstract ResourceNode<R> construct(ResourceNode<?> parentNode);

    @SuppressWarnings("unchecked")
    protected final THIS _this() {
        return (THIS) this;
    }

    protected static <K, V> Map<K, V> _buildMap(List<Entry<K, V>> list) {
        return new LinkedHashMap<K, V>(new ListMap<K, V>(list));
    }
}
