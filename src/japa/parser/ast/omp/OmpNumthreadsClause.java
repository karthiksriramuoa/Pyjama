package japa.parser.ast.omp;

import japa.parser.ast.Node;
import japa.parser.ast.expr.Expression;
import japa.parser.ast.visitor.GenericVisitor;
import japa.parser.ast.visitor.VoidVisitor;

public class OmpNumthreadsClause extends Node{

	private Expression numExpression;
	
	public OmpNumthreadsClause(Expression numExpression) {
		this.numExpression = numExpression;
	}
	
	public OmpNumthreadsClause(int beginLine, int beginColumn, int endLine, int endColumn, Expression numExpression) {
		super(beginLine, beginColumn, endLine, endColumn);
		this.numExpression = numExpression;
	}
	
	public Expression getIfExpression() {
		return this.numExpression;
	}
	
	@Override
	public <R, A> R accept(GenericVisitor<R, A> v, A arg) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <A> void accept(VoidVisitor<A> v, A arg) {
		// TODO Auto-generated method stub
		
	}

}
