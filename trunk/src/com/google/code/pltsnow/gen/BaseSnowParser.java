package com.google.code.pltsnow.gen;

import java.io.IOException;
import java.util.HashSet;

public abstract class BaseSnowParser {
	protected HashSet<String> definedGlobalSymbols;
	protected ParserVal doForeach(ParserVal id,ParserVal in, ParserVal as, ParserVal from, ParserVal stmt)
	{
		System.err.println("doaforeach");
		String r = "";
		String type = "SnowType";
		if(as.sval!= null && in.sval != null)
			r = " for(" + type +" " + as.sval + " : " + in.sval + "){\n";
		r += stmt.sval;
		r += "}\n";
		return new ParserVal(r);
	}
	protected ParserVal doWhile(ParserVal cond, ParserVal stmts)
	{
		String r = "";
		r+="while(" + cond.sval + "){\n" + stmts.sval + "\n}\n";
		return new ParserVal(r);
	}
	protected ParserVal doFor(ParserVal id,ParserVal from,ParserVal to,ParserVal by, ParserVal stmt)
	{
		System.err.println("doafor");
		String r= "";
		r +=  " want for to do  " + stmt;
		return new ParserVal(r);
	}
	protected ParserVal moleLazyCreate(ParserVal num, ParserVal ofWhat)
	{
		String r = "";
		r += "\ttypes.get(mName).addList(\""+ofWhat.sval+"\", "+num.sval+");\n";
		return new ParserVal(r);
	}

	protected ParserVal moleCreateOne(ParserVal thingToMake)
	{
		return new ParserVal("\ttypes.get(mName).addField(\""+thingToMake	.sval+"\");\n");
	}
	protected ParserVal assignVariable(ParserVal id, ParserVal val)
	{
		String rval = val.sval;
		if(rval.contains("getField(") || rval.contains("symbols.get("))
		{
			rval = rval + ".clone()";
		}
		System.err.println("assign " + id.sval + " to " + val.sval);
		if(id.sval.charAt(0) == '~')
			return new ParserVal("public void set_" + id.sval.substring(1) + "(){\n\tsymbols.put(\"" + id.sval + "\"," + rval+ ");\n}\n");
		else if(id.sval.contains("symbols.get(") || id.sval.contains("getField("))
			return new ParserVal(id.sval + ".set("+rval+")");
		else
			return new ParserVal(id.sval + ".set(" + val.sval + ")");
	}
	protected ParserVal declareLocalVariable(ParserVal varName)
	{
		return new ParserVal("SnowAtom  " + varName.sval + " = new SnowAtom(null);");
	}
	protected ParserVal buildCompoundIdentifier(ParserVal left, ParserVal right)
	{
		String l = left.sval;
		if(definedGlobalSymbols.contains(left.sval))
			l = "symbols.get(\"" + l + "\")";
		
		if(right != null)
		{
			return new ParserVal(l+".getField(\"" + right.sval + "\")");
		}
		else
		{
			return new ParserVal(l);
		}
	}
	protected ParserVal createFunction(ParserVal functionName,ParserVal params, ParserVal statements)
	{
		String r = "";
		String parsedParams = params.sval.substring(1);
		if(parsedParams != "")
		{
			parsedParams = "SnowType " + parsedParams;
			parsedParams = parsedParams.replaceAll(",",", SnowType ");
		}
		r += "public SnowType snw_" + functionName.sval + " (" + parsedParams + "){\n";
		r += statements.sval;
		//TODO - implement something to make sure there is a return!
		r += "\n}";
		return new ParserVal(r);
	}
	protected ParserVal createDebugHook(ParserVal timeSeq,ParserVal event,ParserVal statements)
	{
		String r = new String();
		r += ("public void dbg_" + timeSeq.sval.toLowerCase() + event.sval.toUpperCase() + "(){" + "\n");
		r += (statements.sval);
		r += ("}\n");
		return new ParserVal(r);
	}
	protected ParserVal doOp(String op, ParserVal l, ParserVal r)
	{
		String ret ="";
		ret += l.sval + "." + op + "(" + r.sval + ")";
		return new ParserVal(ret);
	}
	protected ParserVal makeFullIfStatement(ParserVal stmt)
	{
		String r = "";
		r += "if(" + stmt.sval + "}";
		return new ParserVal(r);
	}
	protected ParserVal makePartialIf(ParserVal s1, ParserVal s2, ParserVal s3)
	{
		return new ParserVal("there is an if here" + s1.sval);
	}
	protected ParserVal executeFunction(ParserVal fname,ParserVal params)
	{
		return new ParserVal("snw_"+fname.sval+"("+params.sval.substring(1)+")");
	}
	protected ParserVal addLineEnding(ParserVal v)
	{
		return new ParserVal(v.sval + ";\n");
	}
	protected ParserVal defineMolecule(ParserVal name, ParserVal def)
	{
		String r = "";
		definedGlobalSymbols.add(name.sval);
		r+="public void moleDef_" + name.sval + "(){\n";
		r+="types.put(\"" + name.sval + "\",new SnowAtom(SnowType.NIL));\n";
		r+="String mName = \"" + name.sval + "\";\n";
		r+=def.sval;
		r+= "}";
		return new ParserVal(r );
	}
	protected Yylex lexer;

	  /* interface to the lexer */
	  protected int yylex () {
	    int yyl_return = -1;
	    try {
	      yyl_return = lexer.yylex();
	    }
	    catch (IOException e) {
	      System.err.println("IO error :"+e);
	    }
	    return yyl_return;
	  }
	  public BaseSnowParser()
	  {
		  definedGlobalSymbols = new HashSet<String>();
	  }
	protected void yyerror(String s)
	{
	 System.out.println("par:"+s);
	}

	boolean newline;


}
