package com.google.code.pltsnow.gen;

import java.io.IOException;

public abstract class BaseSnowParser {	
	protected ParserVal doForeach(ParserVal id,ParserVal in, ParserVal as, ParserVal from, ParserVal stmt)
	{
		String r = "";
		String type = "SnowType";
		r = " for(" + type +" " + as.sval + " : " + in.sval + "){\n";
		r += stmt.sval;
		r += "}\n";
		return new ParserVal(r);
	}

	protected ParserVal moleLazyCreate(ParserVal num, ParserVal ofWhat)
	{
		String r = "";
		r += "\tpublic ArrayList<SnowType> "+ofWhat.sval+";\n";
		return new ParserVal(r);
	}

	protected ParserVal moleCreateOne(ParserVal thingToMake)
	{
		return new ParserVal("\tpublic Object "+thingToMake.sval+";\n");
	}
	protected ParserVal assignVariable(ParserVal id, ParserVal val)
	{
		if(id.sval.charAt(0) == '~')
			return new ParserVal("protected void set_" + id.sval.substring(1) + "(){\n\tsymbols.put(\"" + id.sval + "\",new SnowType(\"" + val.sval + "\"));\n}\n");
		else if(id.sval.contains("symbols.get("))
			return new ParserVal("symbols.put(" + id.sval.substring(12,id.sval.lastIndexOf("\"") + 1) + ",new SnowType(\"" + val.sval + "\"));");
		else
			return new ParserVal(id.sval + "=" + val.sval + ";");
	}
	protected ParserVal createFunction(ParserVal functionName,ParserVal params, ParserVal statements)
	{
		String r = "";
		String parsedParams = params.sval;
		if(parsedParams != "")
		{
			parsedParams = "SnowType " + parsedParams;
			parsedParams.replace(",",", Object ");
		}
		r += "protected SnowType snw_" + functionName.sval + " (" + parsedParams + "){\n";
		r += statements.sval.replace(functionName.sval+"=","return ");
		
		//TODO - implement something to make sure there is a return!
		r += "\n}";
		return new ParserVal(r);
	}
	protected ParserVal createDebugHook(ParserVal timeSeq,ParserVal event,ParserVal statements)
	{
		String r = new String();
		r += ("protected void dbg_" + timeSeq.sval.toLowerCase() + event.sval.toUpperCase() + "(){" + "\n");
		r += (statements.sval);
		r += ("}\n");
		return new ParserVal(r);
	}

	protected ParserVal executeFunction(ParserVal fname,ParserVal params)
	{
		return new ParserVal("snw_"+fname.sval+"("+params.sval+");\n");
	}

	protected ParserVal defineMolecule(ParserVal name, ParserVal def)
	{
		String r = "";
		r+="class " + name.sval + " extends Base" + name.sval.substring(0,1).toUpperCase() + name.sval.substring(1) + "{\n";
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

	protected void yyerror(String s)
	{
	 System.out.println("par:"+s);
	}

	boolean newline;


}
