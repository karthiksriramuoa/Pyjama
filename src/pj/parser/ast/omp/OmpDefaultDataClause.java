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

package pj.parser.ast.omp;

import java.util.Set;

import pj.parser.ast.expr.Expression;
import pj.parser.ast.visitor.GenericVisitor;
import pj.parser.ast.visitor.SourcePrinter;
import pj.parser.ast.visitor.VoidVisitor;

public class OmpDefaultDataClause extends OmpDataClause{

	public static enum Policy { Shared,None };
	private OmpDefaultDataClause.Policy policy;
	
	public OmpDefaultDataClause() {
		this.type = OmpDataClause.Type.Default;
		this.policy = OmpDefaultDataClause.Policy.None; 
	}
		
	public OmpDefaultDataClause(int beginLine, int beginColumn, int endLine, int endColumn) {
		super(beginLine, beginColumn, endLine, endColumn);
		this.type = OmpDataClause.Type.Default;
		this.policy = OmpDefaultDataClause.Policy.None;
	}
	
	public void setPolicy(OmpDefaultDataClause.Policy policy) {
		this.type = OmpDataClause.Type.Default;
		this.policy = OmpDefaultDataClause.Policy.None;
	}
	
	public OmpDefaultDataClause.Policy getPolicy() {
		return this.policy;
	}
	
	@Override
	public Set<Expression> getArgumentSet() {
		return null;
	}
	
	@Override
	public <R, A> R accept(GenericVisitor<R, A> v, A arg) {
		return v.visit(this, arg);
	}

	@Override
	public <A> void accept(VoidVisitor<A> v, A arg) {
		v.visit(this, arg);	
	}

	@Override
	public void printVariableDefination(OpenMPStatement n, SourcePrinter printer, String prefix) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void printVariableDefinationAndInitialisation(OpenMPStatement n, SourcePrinter printer, String left_prefix,
			String right_prefix) {
		// TODO Auto-generated method stub
		
	}



}
