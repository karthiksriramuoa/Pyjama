/*
 * Copyright (C) 2013-2016 Parallel and Reconfigurable Computing Group, University of Auckland.
 *
 * Authors: <http://homepages.engineering.auckland.ac.nz/~parallel/ParallelIT/People.html>
 * 
 * This file is part of Pyjama, a Java implementation of OpenMP-like directive-based 
 * parallelisation compiler and its runtime routines.
 *
 * Pyjama is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Pyjama is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Pyjama. If not, see <http://www.gnu.org/licenses/>.
 */

/*
 * Copyright (C) 2007 Julio Vilmar Gesser.
 * 
 * This file is part of Java 1.5 parser and Abstract Syntax Tree.
 *
 * Java 1.5 parser and Abstract Syntax Tree is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Java 1.5 parser and Abstract Syntax Tree is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Java 1.5 parser and Abstract Syntax Tree.  If not, see <http://www.gnu.org/licenses/>.
 */
/*
 * Created on 21/11/2006
 */
package pj.parser.ast.body;

import pj.parser.ast.expr.AnnotationExpr;
import pj.parser.ast.expr.Expression;
import pj.parser.ast.type.Type;
import pj.parser.ast.visitor.GenericVisitor;
import pj.parser.ast.visitor.VoidVisitor;

import java.util.List;

/**
 * @author Julio Vilmar Gesser
 */
public final class AnnotationMemberDeclaration extends BodyDeclaration {

    private int modifiers;

    private Type type;

    private String name;

    private Expression defaultValue;

    public AnnotationMemberDeclaration() {
    }

    public AnnotationMemberDeclaration(int modifiers, Type type, String name, Expression defaultValue) {
        this.modifiers = modifiers;
        this.type = type;
        this.name = name;
        this.defaultValue = defaultValue;
    }

    public AnnotationMemberDeclaration(JavadocComment javaDoc, int modifiers, List<AnnotationExpr> annotations, Type type, String name, Expression defaultValue) {
        super(annotations, javaDoc);
        this.modifiers = modifiers;
        this.type = type;
        this.name = name;
        this.defaultValue = defaultValue;
    }

    public AnnotationMemberDeclaration(int beginLine, int beginColumn, int endLine, int endColumn, JavadocComment javaDoc, int modifiers, List<AnnotationExpr> annotations, Type type, String name, Expression defaultValue) {
        super(beginLine, beginColumn, endLine, endColumn, annotations, javaDoc);
        this.modifiers = modifiers;
        this.type = type;
        this.name = name;
        this.defaultValue = defaultValue;
    }

    @Override
    public <R, A> R accept(GenericVisitor<R, A> v, A arg) {
        return v.visit(this, arg);
    }

    @Override
    public <A> void accept(VoidVisitor<A> v, A arg) {
        v.visit(this, arg);
    }

    public Expression getDefaultValue() {
        return defaultValue;
    }

    /**
     * Return the modifiers of this member declaration.
     * 
     * @see ModifierSet
     * @return modifiers
     */
    public int getModifiers() {
        return modifiers;
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }

    public void setDefaultValue(Expression defaultValue) {
        this.defaultValue = defaultValue;
    }

    public void setModifiers(int modifiers) {
        this.modifiers = modifiers;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
