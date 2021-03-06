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

import com.sun.codemodel.ClassType;
import com.sun.codemodel.JClassAlreadyExistsException;
import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;

import javax.annotation.processing.Messager;

import static com.sun.codemodel.ClassType.*;
import static com.sun.codemodel.JMod.*;
import static javax.tools.Diagnostic.Kind.*;

/**
 * @author <a href="mailto:david.lloyd@redhat.com">David M. Lloyd</a>
 */
public abstract class AbstractClassGenerator {
    private final JCodeModel codeModel;
    private final Messager messager;
    private final String packageName;
    private final ClassType classType;
    private final String className;
    private final int modifiers;

    protected AbstractClassGenerator(final JCodeModel codeModel, final Messager messager, final String className, final String packageName, final ClassType classType, final int modifiers) {
        this.codeModel = codeModel;
        this.messager = messager;
        this.className = className;
        this.packageName = packageName;
        this.classType = classType;
        this.modifiers = modifiers;
    }

    public JCodeModel getCodeModel() {
        return codeModel;
    }

    public void generate() {
        final JDefinedClass definedClass;
        final String fqcn = packageName + "." + className;
        try {
            definedClass = codeModel._class(modifiers, fqcn, classType);
        } catch (JClassAlreadyExistsException e) {
            messager.printMessage(ERROR, "Duplicate class generation for " + fqcn);
            return;
        }
        definedClass.direct("/* GENERATED SOURCE - DO NOT EDIT */\n");
        populate(definedClass);
    }

    public Messager getMessager() {
        return messager;
    }

    public String getPackageName() {
        return packageName;
    }

    public String getClassName() {
        return className;
    }

    protected abstract void populate(JDefinedClass definedClass);
}
