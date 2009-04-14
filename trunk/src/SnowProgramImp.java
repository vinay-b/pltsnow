loop
yyn:0  state:0  yychar:-1
 next yychar:304
state 0, shifting to state 6
loop
state 6, reducing 1 by rule 9 (external_declaration : NEWLINE)
reduce
after reduction, shifting from state 0 to state 10
loop
state 10, reducing 1 by rule 2 (program_unit : external_declaration)
reduce
after reduction, shifting from state 0 to state 9
loop
yyn:0  state:9  yychar:-1
 next yychar:309
state 9, shifting to state 7
loop
yyn:0  state:7  yychar:-1
 next yychar:292
state 7, shifting to state 22
loop
yyn:0  state:22  yychar:-1
 next yychar:311
state 22, shifting to state 35
loop
state 35, reducing 1 by rule 11 (atom : NUMERIC)
reduce
after reduction, shifting from state 22 to state 37
loop
state 37, reducing 1 by rule 21 (primary_expression : atom)
reduce
after reduction, shifting from state 22 to state 39
loop
state 39, reducing 1 by rule 29 (postfix_expression : primary_expression)
reduce
after reduction, shifting from state 22 to state 42
loop
yyn:0  state:42  yychar:-1
 next yychar:304
reduce
state 42, reducing 1 by rule 37 (unary_expression : postfix_expression)
reduce
after reduction, shifting from state 22 to state 44
loop
state 44, reducing 1 by rule 47 (pow_expression : unary_expression)
reduce
after reduction, shifting from state 22 to state 47
loop
yyn:0  state:47  yychar:304
reduce
state 47, reducing 1 by rule 46 (multiplicative_expression : pow_expression)
reduce
after reduction, shifting from state 22 to state 46
loop
yyn:0  state:46  yychar:304
reduce
state 46, reducing 1 by rule 40 (additive_expression : multiplicative_expression)
reduce
after reduction, shifting from state 22 to state 45
loop
yyn:0  state:45  yychar:304
reduce
state 45, reducing 1 by rule 49 (relational_expression : additive_expression)
reduce
after reduction, shifting from state 22 to state 48
loop
yyn:0  state:48  yychar:304
reduce
state 48, reducing 1 by rule 54 (equality_expression : relational_expression)
reduce
after reduction, shifting from state 22 to state 49
loop
yyn:0  state:49  yychar:304
reduce
state 49, reducing 1 by rule 57 (logical_and_expression : equality_expression)
reduce
after reduction, shifting from state 22 to state 50
loop
yyn:0  state:50  yychar:304
reduce
state 50, reducing 1 by rule 59 (logical_or_expression : logical_and_expression)
reduce
after reduction, shifting from state 22 to state 51
loop
yyn:0  state:51  yychar:304
reduce
state 51, reducing 1 by rule 74 (expression_t : logical_or_expression)
reduce
after reduction, shifting from state 22 to state 52
loop
state 52, reducing 1 by rule 72 (expression : expression_t)
reduce
after reduction, shifting from state 22 to state 36
loop
state 36, reducing 3 by rule 10 (global_variable_assignment : SYS_IDENTIFIER EQUALS expression)
reduce
after reduction, shifting from state 9 to state 15
loop
state 15, reducing 1 by rule 8 (external_declaration : global_variable_assignment)
reduce
after reduction, shifting from state 9 to state 23
loop
state 23, reducing 2 by rule 3 (program_unit : program_unit external_declaration)
reduce
after reduction, shifting from state 0 to state 9
loop
yyn:0  state:9  yychar:304
state 9, shifting to state 6
loop
state 6, reducing 1 by rule 9 (external_declaration : NEWLINE)
reduce
after reduction, shifting from state 9 to state 23
loop
state 23, reducing 2 by rule 3 (program_unit : program_unit external_declaration)
reduce
after reduction, shifting from state 0 to state 9
loop
yyn:0  state:9  yychar:-1
 next yychar:309
state 9, shifting to state 7
loop
yyn:0  state:7  yychar:-1
 next yychar:292
state 7, shifting to state 22
loop
yyn:0  state:22  yychar:-1
 next yychar:311
state 22, shifting to state 35
loop
state 35, reducing 1 by rule 11 (atom : NUMERIC)
reduce
after reduction, shifting from state 22 to state 37
loop
state 37, reducing 1 by rule 21 (primary_expression : atom)
reduce
after reduction, shifting from state 22 to state 39
loop
state 39, reducing 1 by rule 29 (postfix_expression : primary_expression)
reduce
after reduction, shifting from state 22 to state 42
loop
yyn:0  state:42  yychar:-1
 next yychar:304
reduce
state 42, reducing 1 by rule 37 (unary_expression : postfix_expression)
reduce
after reduction, shifting from state 22 to state 44
loop
state 44, reducing 1 by rule 47 (pow_expression : unary_expression)
reduce
after reduction, shifting from state 22 to state 47
loop
yyn:0  state:47  yychar:304
reduce
state 47, reducing 1 by rule 46 (multiplicative_expression : pow_expression)
reduce
after reduction, shifting from state 22 to state 46
loop
yyn:0  state:46  yychar:304
reduce
state 46, reducing 1 by rule 40 (additive_expression : multiplicative_expression)
reduce
after reduction, shifting from state 22 to state 45
loop
yyn:0  state:45  yychar:304
reduce
state 45, reducing 1 by rule 49 (relational_expression : additive_expression)
reduce
after reduction, shifting from state 22 to state 48
loop
yyn:0  state:48  yychar:304
reduce
state 48, reducing 1 by rule 54 (equality_expression : relational_expression)
reduce
after reduction, shifting from state 22 to state 49
loop
yyn:0  state:49  yychar:304
reduce
state 49, reducing 1 by rule 57 (logical_and_expression : equality_expression)
reduce
after reduction, shifting from state 22 to state 50
loop
yyn:0  state:50  yychar:304
reduce
state 50, reducing 1 by rule 59 (logical_or_expression : logical_and_expression)
reduce
after reduction, shifting from state 22 to state 51
loop
yyn:0  state:51  yychar:304
reduce
state 51, reducing 1 by rule 74 (expression_t : logical_or_expression)
reduce
after reduction, shifting from state 22 to state 52
loop
state 52, reducing 1 by rule 72 (expression : expression_t)
reduce
after reduction, shifting from state 22 to state 36
loop
state 36, reducing 3 by rule 10 (global_variable_assignment : SYS_IDENTIFIER EQUALS expression)
reduce
after reduction, shifting from state 9 to state 15
loop
state 15, reducing 1 by rule 8 (external_declaration : global_variable_assignment)
reduce
after reduction, shifting from state 9 to state 23
loop
state 23, reducing 2 by rule 3 (program_unit : program_unit external_declaration)
reduce
after reduction, shifting from state 0 to state 9
loop
yyn:0  state:9  yychar:304
state 9, shifting to state 6
loop
state 6, reducing 1 by rule 9 (external_declaration : NEWLINE)
reduce
after reduction, shifting from state 9 to state 23
loop
state 23, reducing 2 by rule 3 (program_unit : program_unit external_declaration)
reduce
after reduction, shifting from state 0 to state 9
loop
yyn:0  state:9  yychar:-1
 next yychar:309
state 9, shifting to state 7
loop
yyn:0  state:7  yychar:-1
 next yychar:292
state 7, shifting to state 22
loop
yyn:0  state:22  yychar:-1
 next yychar:311
state 22, shifting to state 35
loop
state 35, reducing 1 by rule 11 (atom : NUMERIC)
reduce
after reduction, shifting from state 22 to state 37
loop
state 37, reducing 1 by rule 21 (primary_expression : atom)
reduce
after reduction, shifting from state 22 to state 39
loop
state 39, reducing 1 by rule 29 (postfix_expression : primary_expression)
reduce
after reduction, shifting from state 22 to state 42
loop
yyn:0  state:42  yychar:-1
 next yychar:304
reduce
state 42, reducing 1 by rule 37 (unary_expression : postfix_expression)
reduce
after reduction, shifting from state 22 to state 44
loop
state 44, reducing 1 by rule 47 (pow_expression : unary_expression)
reduce
after reduction, shifting from state 22 to state 47
loop
yyn:0  state:47  yychar:304
reduce
state 47, reducing 1 by rule 46 (multiplicative_expression : pow_expression)
reduce
after reduction, shifting from state 22 to state 46
loop
yyn:0  state:46  yychar:304
reduce
state 46, reducing 1 by rule 40 (additive_expression : multiplicative_expression)
reduce
after reduction, shifting from state 22 to state 45
loop
yyn:0  state:45  yychar:304
reduce
state 45, reducing 1 by rule 49 (relational_expression : additive_expression)
reduce
after reduction, shifting from state 22 to state 48
loop
yyn:0  state:48  yychar:304
reduce
state 48, reducing 1 by rule 54 (equality_expression : relational_expression)
reduce
after reduction, shifting from state 22 to state 49
loop
yyn:0  state:49  yychar:304
reduce
state 49, reducing 1 by rule 57 (logical_and_expression : equality_expression)
reduce
after reduction, shifting from state 22 to state 50
loop
yyn:0  state:50  yychar:304
reduce
state 50, reducing 1 by rule 59 (logical_or_expression : logical_and_expression)
reduce
after reduction, shifting from state 22 to state 51
loop
yyn:0  state:51  yychar:304
reduce
state 51, reducing 1 by rule 74 (expression_t : logical_or_expression)
reduce
after reduction, shifting from state 22 to state 52
loop
state 52, reducing 1 by rule 72 (expression : expression_t)
reduce
after reduction, shifting from state 22 to state 36
loop
state 36, reducing 3 by rule 10 (global_variable_assignment : SYS_IDENTIFIER EQUALS expression)
reduce
after reduction, shifting from state 9 to state 15
loop
state 15, reducing 1 by rule 8 (external_declaration : global_variable_assignment)
reduce
after reduction, shifting from state 9 to state 23
loop
state 23, reducing 2 by rule 3 (program_unit : program_unit external_declaration)
reduce
after reduction, shifting from state 0 to state 9
loop
yyn:0  state:9  yychar:304
state 9, shifting to state 6
loop
state 6, reducing 1 by rule 9 (external_declaration : NEWLINE)
reduce
after reduction, shifting from state 9 to state 23
loop
state 23, reducing 2 by rule 3 (program_unit : program_unit external_declaration)
reduce
after reduction, shifting from state 0 to state 9
loop
yyn:0  state:9  yychar:-1
 next yychar:309
state 9, shifting to state 7
loop
yyn:0  state:7  yychar:-1
 next yychar:292
state 7, shifting to state 22
loop
yyn:0  state:22  yychar:-1
 next yychar:296
state 22, shifting to state 31
loop
yyn:0  state:31  yychar:-1
 next yychar:308
state 31, shifting to state 32
loop
yyn:0  state:32  yychar:-1
 next yychar:298
state 32, shifting to state 64
loop
state 64, reducing 0 by rule 35 (params :)
reduce
after reduction, shifting from state 64 to state 99
loop
yyn:0  state:99  yychar:-1
 next yychar:311
reduce
state 99, reducing 0 by rule 14 (commaq :)
reduce
after reduction, shifting from state 99 to state 85
loop
yyn:0  state:85  yychar:311
state 85, shifting to state 35
loop
state 35, reducing 1 by rule 11 (atom : NUMERIC)
reduce
after reduction, shifting from state 85 to state 37
loop
state 37, reducing 1 by rule 21 (primary_expression : atom)
reduce
after reduction, shifting from state 85 to state 39
loop
state 39, reducing 1 by rule 29 (postfix_expression : primary_expression)
reduce
after reduction, shifting from state 85 to state 42
loop
yyn:0  state:42  yychar:-1
 next yychar:311
reduce
state 42, reducing 1 by rule 37 (unary_expression : postfix_expression)
reduce
after reduction, shifting from state 85 to state 44
loop
state 44, reducing 1 by rule 47 (pow_expression : unary_expression)
reduce
after reduction, shifting from state 85 to state 47
loop
yyn:0  state:47  yychar:311
reduce
state 47, reducing 1 by rule 46 (multiplicative_expression : pow_expression)
reduce
after reduction, shifting from state 85 to state 46
loop
yyn:0  state:46  yychar:311
reduce
state 46, reducing 1 by rule 40 (additive_expression : multiplicative_expression)
reduce
after reduction, shifting from state 85 to state 45
loop
yyn:0  state:45  yychar:311
reduce
state 45, reducing 1 by rule 49 (relational_expression : additive_expression)
reduce
after reduction, shifting from state 85 to state 48
loop
yyn:0  state:48  yychar:311
reduce
state 48, reducing 1 by rule 54 (equality_expression : relational_expression)
reduce
after reduction, shifting from state 85 to state 49
loop
yyn:0  state:49  yychar:311
reduce
state 49, reducing 1 by rule 57 (logical_and_expression : equality_expression)
reduce
after reduction, shifting from state 85 to state 50
loop
yyn:0  state:50  yychar:311
reduce
state 50, reducing 1 by rule 59 (logical_or_expression : logical_and_expression)
reduce
after reduction, shifting from state 85 to state 51
loop
yyn:0  state:51  yychar:311
reduce
state 51, reducing 1 by rule 74 (expression_t : logical_or_expression)
reduce
after reduction, shifting from state 85 to state 52
loop
state 52, reducing 1 by rule 72 (expression : expression_t)
reduce
after reduction, shifting from state 85 to state 131
loop
state 131, reducing 1 by rule 36 (param : expression)
reduce
after reduction, shifting from state 85 to state 132
loop
state 132, reducing 3 by rule 34 (params : params commaq param)
reduce
after reduction, shifting from state 64 to state 99
loop
yyn:0  state:99  yychar:311
reduce
state 99, reducing 0 by rule 14 (commaq :)
reduce
after reduction, shifting from state 99 to state 85
loop
yyn:0  state:85  yychar:311
state 85, shifting to state 35
loop
state 35, reducing 1 by rule 11 (atom : NUMERIC)
reduce
after reduction, shifting from state 85 to state 37
loop
state 37, reducing 1 by rule 21 (primary_expression : atom)
reduce
after reduction, shifting from state 85 to state 39
loop
state 39, reducing 1 by rule 29 (postfix_expression : primary_expression)
reduce
after reduction, shifting from state 85 to state 42
loop
yyn:0  state:42  yychar:-1
 next yychar:297
reduce
state 42, reducing 1 by rule 37 (unary_expression : postfix_expression)
reduce
after reduction, shifting from state 85 to state 44
loop
state 44, reducing 1 by rule 47 (pow_expression : unary_expression)
reduce
after reduction, shifting from state 85 to state 47
loop
yyn:0  state:47  yychar:297
reduce
state 47, reducing 1 by rule 46 (multiplicative_expression : pow_expression)
reduce
after reduction, shifting from state 85 to state 46
loop
yyn:0  state:46  yychar:297
reduce
state 46, reducing 1 by rule 40 (additive_expression : multiplicative_expression)
reduce
after reduction, shifting from state 85 to state 45
loop
yyn:0  state:45  yychar:297
reduce
state 45, reducing 1 by rule 49 (relational_expression : additive_expression)
reduce
after reduction, shifting from state 85 to state 48
loop
yyn:0  state:48  yychar:297
reduce
state 48, reducing 1 by rule 54 (equality_expression : relational_expression)
reduce
after reduction, shifting from state 85 to state 49
loop
yyn:0  state:49  yychar:297
reduce
state 49, reducing 1 by rule 57 (logical_and_expression : equality_expression)
reduce
after reduction, shifting from state 85 to state 50
loop
yyn:0  state:50  yychar:297
reduce
state 50, reducing 1 by rule 59 (logical_or_expression : logical_and_expression)
reduce
after reduction, shifting from state 85 to state 51
loop
yyn:0  state:51  yychar:297
reduce
state 51, reducing 1 by rule 74 (expression_t : logical_or_expression)
reduce
after reduction, shifting from state 85 to state 52
loop
state 52, reducing 1 by rule 72 (expression : expression_t)
reduce
after reduction, shifting from state 85 to state 131
loop
state 131, reducing 1 by rule 36 (param : expression)
reduce
after reduction, shifting from state 85 to state 132
loop
state 132, reducing 3 by rule 34 (params : params commaq param)
reduce
after reduction, shifting from state 64 to state 99
loop
yyn:0  state:99  yychar:297
reduce
state 99, reducing 3 by rule 33 (function_expression : IDENTIFIER COLON params)
reduce
after reduction, shifting from state 31 to state 43
loop
state 43, reducing 1 by rule 32 (postfix_expression : function_expression)
reduce
after reduction, shifting from state 31 to state 42
loop
yyn:0  state:42  yychar:297
reduce
state 42, reducing 1 by rule 37 (unary_expression : postfix_expression)
reduce
after reduction, shifting from state 31 to state 44
loop
state 44, reducing 1 by rule 47 (pow_expression : unary_expression)
reduce
after reduction, shifting from state 31 to state 47
loop
yyn:0  state:47  yychar:297
reduce
state 47, reducing 1 by rule 46 (multiplicative_expression : pow_expression)
reduce
after reduction, shifting from state 31 to state 46
loop
yyn:0  state:46  yychar:297
reduce
state 46, reducing 1 by rule 40 (additive_expression : multiplicative_expression)
reduce
after reduction, shifting from state 31 to state 45
loop
yyn:0  state:45  yychar:297
reduce
state 45, reducing 1 by rule 49 (relational_expression : additive_expression)
reduce
after reduction, shifting from state 31 to state 48
loop
yyn:0  state:48  yychar:297
reduce
state 48, reducing 1 by rule 54 (equality_expression : relational_expression)
reduce
after reduction, shifting from state 31 to state 49
loop
yyn:0  state:49  yychar:297
reduce
state 49, reducing 1 by rule 57 (logical_and_expression : equality_expression)
reduce
after reduction, shifting from state 31 to state 50
loop
yyn:0  state:50  yychar:297
reduce
state 50, reducing 1 by rule 59 (logical_or_expression : logical_and_expression)
reduce
after reduction, shifting from state 31 to state 51
loop
yyn:0  state:51  yychar:297
reduce
state 51, reducing 1 by rule 74 (expression_t : logical_or_expression)
reduce
after reduction, shifting from state 31 to state 52
loop
state 52, reducing 1 by rule 72 (expression : expression_t)
reduce
after reduction, shifting from state 31 to state 61
loop
yyn:0  state:61  yychar:297
state 61, shifting to state 95
loop
state 95, reducing 3 by rule 24 (primary_expression : LPAREN expression RPAREN)
reduce
after reduction, shifting from state 22 to state 39
loop
state 39, reducing 1 by rule 29 (postfix_expression : primary_expression)
reduce
after reduction, shifting from state 22 to state 42
loop
yyn:0  state:42  yychar:-1
 next yychar:282
reduce
state 42, reducing 1 by rule 37 (unary_expression : postfix_expression)
reduce
after reduction, shifting from state 22 to state 44
loop
state 44, reducing 1 by rule 47 (pow_expression : unary_expression)
reduce
after reduction, shifting from state 22 to state 47
loop
yyn:0  state:47  yychar:282
reduce
state 47, reducing 1 by rule 46 (multiplicative_expression : pow_expression)
reduce
after reduction, shifting from state 22 to state 46
loop
yyn:0  state:46  yychar:282
state 46, shifting to state 71
loop
yyn:0  state:71  yychar:-1
 next yychar:311
state 71, shifting to state 35
loop
state 35, reducing 1 by rule 11 (atom : NUMERIC)
reduce
after reduction, shifting from state 71 to state 37
loop
state 37, reducing 1 by rule 21 (primary_expression : atom)
reduce
after reduction, shifting from state 71 to state 39
loop
state 39, reducing 1 by rule 29 (postfix_expression : primary_expression)
reduce
after reduction, shifting from state 71 to state 42
loop
yyn:0  state:42  yychar:-1
 next yychar:304
reduce
state 42, reducing 1 by rule 37 (unary_expression : postfix_expression)
reduce
after reduction, shifting from state 71 to state 44
loop
state 44, reducing 1 by rule 47 (pow_expression : unary_expression)
reduce
after reduction, shifting from state 71 to state 104
loop
yyn:0  state:104  yychar:304
reduce
state 104, reducing 3 by rule 44 (multiplicative_expression : multiplicative_expression DIV pow_expression)
reduce
after reduction, shifting from state 22 to state 46
loop
yyn:0  state:46  yychar:304
reduce
state 46, reducing 1 by rule 40 (additive_expression : multiplicative_expression)
reduce
after reduction, shifting from state 22 to state 45
loop
yyn:0  state:45  yychar:304
reduce
state 45, reducing 1 by rule 49 (relational_expression : additive_expression)
reduce
after reduction, shifting from state 22 to state 48
loop
yyn:0  state:48  yychar:304
reduce
state 48, reducing 1 by rule 54 (equality_expression : relational_expression)
reduce
after reduction, shifting from state 22 to state 49
loop
yyn:0  state:49  yychar:304
reduce
state 49, reducing 1 by rule 57 (logical_and_expression : equality_expression)
reduce
after reduction, shifting from state 22 to state 50
loop
yyn:0  state:50  yychar:304
reduce
state 50, reducing 1 by rule 59 (logical_or_expression : logical_and_expression)
reduce
after reduction, shifting from state 22 to state 51
loop
yyn:0  state:51  yychar:304
reduce
state 51, reducing 1 by rule 74 (expression_t : logical_or_expression)
reduce
after reduction, shifting from state 22 to state 52
loop
state 52, reducing 1 by rule 72 (expression : expression_t)
reduce
after reduction, shifting from state 22 to state 36
loop
state 36, reducing 3 by rule 10 (global_variable_assignment : SYS_IDENTIFIER EQUALS expression)
reduce
after reduction, shifting from state 9 to state 15
loop
state 15, reducing 1 by rule 8 (external_declaration : global_variable_assignment)
reduce
after reduction, shifting from state 9 to state 23
loop
state 23, reducing 2 by rule 3 (program_unit : program_unit external_declaration)
reduce
after reduction, shifting from state 0 to state 9
loop
yyn:0  state:9  yychar:304
state 9, shifting to state 6
loop
state 6, reducing 1 by rule 9 (external_declaration : NEWLINE)
reduce
after reduction, shifting from state 9 to state 23
loop
state 23, reducing 2 by rule 3 (program_unit : program_unit external_declaration)
reduce
after reduction, shifting from state 0 to state 9
loop
yyn:0  state:9  yychar:-1
 next yychar:304
state 9, shifting to state 6
loop
state 6, reducing 1 by rule 9 (external_declaration : NEWLINE)
reduce
after reduction, shifting from state 9 to state 23
loop
state 23, reducing 2 by rule 3 (program_unit : program_unit external_declaration)
reduce
after reduction, shifting from state 0 to state 9
loop
yyn:0  state:9  yychar:-1
 next yychar:304
state 9, shifting to state 6
loop
state 6, reducing 1 by rule 9 (external_declaration : NEWLINE)
reduce
after reduction, shifting from state 9 to state 23
loop
state 23, reducing 2 by rule 3 (program_unit : program_unit external_declaration)
reduce
after reduction, shifting from state 0 to state 9
loop
yyn:0  state:9  yychar:-1
 next yychar:264
state 9, shifting to state 2
loop
yyn:0  state:2  yychar:-1
 next yychar:308
state 2, shifting to state 18
loop
yyn:0  state:18  yychar:-1
 next yychar:298
state 18, shifting to state 26
loop
yyn:0  state:26  yychar:-1
 next yychar:304
state 26, shifting to state 55
loop
yyn:0  state:55  yychar:-1
 next yychar:308
state 55, shifting to state 88
loop
state 88, reducing 1 by rule 28 (compound_identifier : IDENTIFIER)
reduce
after reduction, shifting from state 55 to state 41
loop
yyn:0  state:41  yychar:-1
 next yychar:304
reduce
state 41, reducing 1 by rule 25 (identifier : compound_identifier)
reduce
after reduction, shifting from state 55 to state 91
loop
yyn:0  state:91  yychar:304
state 91, shifting to state 136
loop
state 136, reducing 2 by rule 105 (molecule_def : identifier NEWLINE)
reduce
after reduction, shifting from state 55 to state 93
loop
state 93, reducing 1 by rule 102 (molecule_defs : molecule_def)
reduce
after reduction, shifting from state 55 to state 92
loop
yyn:0  state:92  yychar:-1
 next yychar:263
state 92, shifting to state 137
loop
state 137, reducing 6 by rule 101 (molecule_declarator : DEFINE IDENTIFIER COLON NEWLINE molecule_defs END)
reduce
after reduction, shifting from state 9 to state 13
loop
state 13, reducing 1 by rule 6 (external_declaration : molecule_declarator)
reduce
after reduction, shifting from state 9 to state 23
loop
state 23, reducing 2 by rule 3 (program_unit : program_unit external_declaration)
reduce
after reduction, shifting from state 0 to state 9
loop
yyn:0  state:9  yychar:-1
 next yychar:304
state 9, shifting to state 6
loop
state 6, reducing 1 by rule 9 (external_declaration : NEWLINE)
reduce
after reduction, shifting from state 9 to state 23
loop
state 23, reducing 2 by rule 3 (program_unit : program_unit external_declaration)
reduce
after reduction, shifting from state 0 to state 9
loop
yyn:0  state:9  yychar:-1
 next yychar:304
state 9, shifting to state 6
loop
state 6, reducing 1 by rule 9 (external_declaration : NEWLINE)
reduce
after reduction, shifting from state 9 to state 23
loop
state 23, reducing 2 by rule 3 (program_unit : program_unit external_declaration)
reduce
after reduction, shifting from state 0 to state 9
loop
yyn:0  state:9  yychar:-1
 next yychar:304
state 9, shifting to state 6
loop
state 6, reducing 1 by rule 9 (external_declaration : NEWLINE)
reduce
after reduction, shifting from state 9 to state 23
loop
state 23, reducing 2 by rule 3 (program_unit : program_unit external_declaration)
reduce
after reduction, shifting from state 0 to state 9
loop
yyn:0  state:9  yychar:-1
 next yychar:264
state 9, shifting to state 2
loop
yyn:0  state:2  yychar:-1
 next yychar:308
state 2, shifting to state 18
loop
yyn:0  state:18  yychar:-1
 next yychar:298
state 18, shifting to state 26
loop
yyn:0  state:26  yychar:-1
 next yychar:304
state 26, shifting to state 55
loop
yyn:0  state:55  yychar:-1
 next yychar:311
state 55, shifting to state 89
loop
yyn:0  state:89  yychar:-1
 next yychar:308
state 89, shifting to state 134
loop
yyn:0  state:134  yychar:-1
 next yychar:304
state 134, shifting to state 159
loop
state 159, reducing 3 by rule 104 (molecule_def : NUMERIC IDENTIFIER NEWLINE)
reduce
after reduction, shifting from state 55 to state 93
loop
state 93, reducing 1 by rule 102 (molecule_defs : molecule_def)
reduce
after reduction, shifting from state 55 to state 92
loop
yyn:0  state:92  yychar:-1
 next yychar:263
state 92, shifting to state 137
loop
state 137, reducing 6 by rule 101 (molecule_declarator : DEFINE IDENTIFIER COLON NEWLINE molecule_defs END)
reduce
after reduction, shifting from state 9 to state 13
loop
state 13, reducing 1 by rule 6 (external_declaration : molecule_declarator)
reduce
after reduction, shifting from state 9 to state 23
loop
state 23, reducing 2 by rule 3 (program_unit : program_unit external_declaration)
reduce
after reduction, shifting from state 0 to state 9
loop
yyn:0  state:9  yychar:-1
 next yychar:304
state 9, shifting to state 6
loop
state 6, reducing 1 by rule 9 (external_declaration : NEWLINE)
reduce
after reduction, shifting from state 9 to state 23
loop
state 23, reducing 2 by rule 3 (program_unit : program_unit external_declaration)
reduce
after reduction, shifting from state 0 to state 9
loop
yyn:0  state:9  yychar:-1
 next yychar:304
state 9, shifting to state 6
loop
state 6, reducing 1 by rule 9 (external_declaration : NEWLINE)
reduce
after reduction, shifting from state 9 to state 23
loop
state 23, reducing 2 by rule 3 (program_unit : program_unit external_declaration)
reduce
after reduction, shifting from state 0 to state 9
loop
yyn:0  state:9  yychar:-1
 next yychar:264
state 9, shifting to state 2
loop
yyn:0  state:2  yychar:-1
 next yychar:308
state 2, shifting to state 18
loop
yyn:0  state:18  yychar:-1
 next yychar:298
state 18, shifting to state 26
loop
yyn:0  state:26  yychar:-1
 next yychar:304
state 26, shifting to state 55
loop
yyn:0  state:55  yychar:-1
 next yychar:311
state 55, shifting to state 89
loop
yyn:0  state:89  yychar:-1
 next yychar:308
state 89, shifting to state 134
loop
yyn:0  state:134  yychar:-1
 next yychar:304
state 134, shifting to state 159
loop
state 159, reducing 3 by rule 104 (molecule_def : NUMERIC IDENTIFIER NEWLINE)
reduce
after reduction, shifting from state 55 to state 93
loop
state 93, reducing 1 by rule 102 (molecule_defs : molecule_def)
reduce
after reduction, shifting from state 55 to state 92
loop
yyn:0  state:92  yychar:-1
 next yychar:263
state 92, shifting to state 137
loop
state 137, reducing 6 by rule 101 (molecule_declarator : DEFINE IDENTIFIER COLON NEWLINE molecule_defs END)
reduce
after reduction, shifting from state 9 to state 13
loop
state 13, reducing 1 by rule 6 (external_declaration : molecule_declarator)
reduce
after reduction, shifting from state 9 to state 23
loop
state 23, reducing 2 by rule 3 (program_unit : program_unit external_declaration)
reduce
after reduction, shifting from state 0 to state 9
loop
yyn:0  state:9  yychar:-1
 next yychar:304
state 9, shifting to state 6
loop
state 6, reducing 1 by rule 9 (external_declaration : NEWLINE)
reduce
after reduction, shifting from state 9 to state 23
loop
state 23, reducing 2 by rule 3 (program_unit : program_unit external_declaration)
reduce
after reduction, shifting from state 0 to state 9
loop
yyn:0  state:9  yychar:-1
 next yychar:304
state 9, shifting to state 6
loop
state 6, reducing 1 by rule 9 (external_declaration : NEWLINE)
reduce
after reduction, shifting from state 9 to state 23
loop
state 23, reducing 2 by rule 3 (program_unit : program_unit external_declaration)
reduce
after reduction, shifting from state 0 to state 9
loop
yyn:0  state:9  yychar:-1
 next yychar:257
state 9, shifting to state 1
loop
yyn:0  state:1  yychar:-1
 next yychar:308
state 1, shifting to state 17
loop
yyn:0  state:17  yychar:-1
 next yychar:298
state 17, shifting to state 25
loop
state 25, reducing 0 by rule 35 (params :)
reduce
after reduction, shifting from state 25 to state 54
loop
yyn:0  state:54  yychar:-1
 next yychar:308
reduce
state 54, reducing 0 by rule 14 (commaq :)
reduce
after reduction, shifting from state 54 to state 85
loop
yyn:0  state:85  yychar:308
state 85, shifting to state 32
loop
yyn:0  state:32  yychar:-1
 next yychar:304
reduce
state 32, reducing 1 by rule 28 (compound_identifier : IDENTIFIER)
reduce
after reduction, shifting from state 85 to state 41
loop
yyn:0  state:41  yychar:304
reduce
state 41, reducing 1 by rule 25 (identifier : compound_identifier)
reduce
after reduction, shifting from state 85 to state 40
loop
state 40, reducing 1 by rule 23 (primary_expression : identifier)
reduce
after reduction, shifting from state 85 to state 39
loop
state 39, reducing 1 by rule 29 (postfix_expression : primary_expression)
reduce
after reduction, shifting from state 85 to state 42
loop
yyn:0  state:42  yychar:304
reduce
state 42, reducing 1 by rule 37 (unary_expression : postfix_expression)
reduce
after reduction, shifting from state 85 to state 44
loop
state 44, reducing 1 by rule 47 (pow_expression : unary_expression)
reduce
after reduction, shifting from state 85 to state 47
loop
yyn:0  state:47  yychar:304
reduce
state 47, reducing 1 by rule 46 (multiplicative_expression : pow_expression)
reduce
after reduction, shifting from state 85 to state 46
loop
yyn:0  state:46  yychar:304
reduce
state 46, reducing 1 by rule 40 (additive_expression : multiplicative_expression)
reduce
after reduction, shifting from state 85 to state 45
loop
yyn:0  state:45  yychar:304
reduce
state 45, reducing 1 by rule 49 (relational_expression : additive_expression)
reduce
after reduction, shifting from state 85 to state 48
loop
yyn:0  state:48  yychar:304
reduce
state 48, reducing 1 by rule 54 (equality_expression : relational_expression)
reduce
after reduction, shifting from state 85 to state 49
loop
yyn:0  state:49  yychar:304
reduce
state 49, reducing 1 by rule 57 (logical_and_expression : equality_expression)
reduce
after reduction, shifting from state 85 to state 50
loop
yyn:0  state:50  yychar:304
reduce
state 50, reducing 1 by rule 59 (logical_or_expression : logical_and_expression)
reduce
after reduction, shifting from state 85 to state 51
loop
yyn:0  state:51  yychar:304
reduce
state 51, reducing 1 by rule 74 (expression_t : logical_or_expression)
reduce
after reduction, shifting from state 85 to state 52
loop
state 52, reducing 1 by rule 72 (expression : expression_t)
reduce
after reduction, shifting from state 85 to state 131
loop
state 131, reducing 1 by rule 36 (param : expression)
reduce
after reduction, shifting from state 85 to state 132
loop
state 132, reducing 3 by rule 34 (params : params commaq param)
reduce
after reduction, shifting from state 25 to state 54
loop
yyn:0  state:54  yychar:304
state 54, shifting to state 84
loop
yyn:0  state:84  yychar:-1
 next yychar:304
state 84, shifting to state 119
loop
state 119, reducing 1 by rule 67 (statement : NEWLINE)
reduce
after reduction, shifting from state 84 to state 124
loop
state 124, reducing 1 by rule 68 (statements : statement)
reduce
after reduction, shifting from state 84 to state 130
loop
yyn:0  state:130  yychar:-1
 next yychar:259
state 130, shifting to state 116
loop
yyn:0  state:116  yychar:-1
 next yychar:308
state 116, shifting to state 88
loop
state 88, reducing 1 by rule 28 (compound_identifier : IDENTIFIER)
reduce
after reduction, shifting from state 116 to state 41
loop
yyn:0  state:41  yychar:-1
 next yychar:276
reduce
state 41, reducing 1 by rule 25 (identifier : compound_identifier)
reduce
after reduction, shifting from state 116 to state 145
loop
yyn:0  state:145  yychar:276
state 145, shifting to state 164
loop
yyn:0  state:164  yychar:-1
 next yychar:308
state 164, shifting to state 88
loop
state 88, reducing 1 by rule 28 (compound_identifier : IDENTIFIER)
reduce
after reduction, shifting from state 164 to state 41
loop
yyn:0  state:41  yychar:-1
 next yychar:300
state 41, shifting to state 65
loop
yyn:0  state:65  yychar:-1
 next yychar:308
state 65, shifting to state 100
loop
state 100, reducing 3 by rule 27 (compound_identifier : compound_identifier DOT IDENTIFIER)
reduce
after reduction, shifting from state 164 to state 41
loop
yyn:0  state:41  yychar:-1
 next yychar:271
reduce
state 41, reducing 1 by rule 25 (identifier : compound_identifier)
reduce
after reduction, shifting from state 164 to state 173
loop
state 173, reducing 2 by rule 84 (in_statement : IN identifier)
reduce
after reduction, shifting from state 145 to state 165
loop
yyn:0  state:165  yychar:271
state 165, shifting to state 174
loop
yyn:0  state:174  yychar:-1
 next yychar:308
state 174, shifting to state 88
loop
state 88, reducing 1 by rule 28 (compound_identifier : IDENTIFIER)
reduce
after reduction, shifting from state 174 to state 41
loop
yyn:0  state:41  yychar:-1
 next yychar:304
reduce
state 41, reducing 1 by rule 25 (identifier : compound_identifier)
reduce
after reduction, shifting from state 174 to state 180
loop
state 180, reducing 2 by rule 82 (as_statement : AS identifier)
reduce
after reduction, shifting from state 165 to state 175
loop
yyn:0  state:175  yychar:304
reduce
state 175, reducing 0 by rule 87 (from_statement :)
reduce
after reduction, shifting from state 175 to state 182
loop
yyn:0  state:182  yychar:304
state 182, shifting to state 188
loop
yyn:0  state:188  yychar:-1
 next yychar:308
state 188, shifting to state 32
loop
yyn:0  state:32  yychar:-1
 next yychar:300
reduce
state 32, reducing 1 by rule 28 (compound_identifier : IDENTIFIER)
reduce
after reduction, shifting from state 188 to state 122
loop
yyn:0  state:122  yychar:300
state 122, shifting to state 65
loop
yyn:0  state:65  yychar:-1
 next yychar:308
state 65, shifting to state 100
loop
state 100, reducing 3 by rule 27 (compound_identifier : compound_identifier DOT IDENTIFIER)
reduce
after reduction, shifting from state 188 to state 122
loop
yyn:0  state:122  yychar:-1
 next yychar:292
state 122, shifting to state 150
loop
yyn:0  state:150  yychar:-1
 next yychar:308
state 150, shifting to state 32
loop
yyn:0  state:32  yychar:-1
 next yychar:298
state 32, shifting to state 64
loop
state 64, reducing 0 by rule 35 (params :)
reduce
after reduction, shifting from state 64 to state 99
loop
yyn:0  state:99  yychar:-1
 next yychar:311
reduce
state 99, reducing 0 by rule 14 (commaq :)
reduce
after reduction, shifting from state 99 to state 85
loop
yyn:0  state:85  yychar:311
state 85, shifting to state 35
loop
state 35, reducing 1 by rule 11 (atom : NUMERIC)
reduce
after reduction, shifting from state 85 to state 37
loop
state 37, reducing 1 by rule 21 (primary_expression : atom)
reduce
after reduction, shifting from state 85 to state 39
loop
state 39, reducing 1 by rule 29 (postfix_expression : primary_expression)
reduce
after reduction, shifting from state 85 to state 42
loop
yyn:0  state:42  yychar:-1
 next yychar:311
reduce
state 42, reducing 1 by rule 37 (unary_expression : postfix_expression)
reduce
after reduction, shifting from state 85 to state 44
loop
state 44, reducing 1 by rule 47 (pow_expression : unary_expression)
reduce
after reduction, shifting from state 85 to state 47
loop
yyn:0  state:47  yychar:311
reduce
state 47, reducing 1 by rule 46 (multiplicative_expression : pow_expression)
reduce
after reduction, shifting from state 85 to state 46
loop
yyn:0  state:46  yychar:311
reduce
state 46, reducing 1 by rule 40 (additive_expression : multiplicative_expression)
reduce
after reduction, shifting from state 85 to state 45
loop
yyn:0  state:45  yychar:311
reduce
state 45, reducing 1 by rule 49 (relational_expression : additive_expression)
reduce
after reduction, shifting from state 85 to state 48
loop
yyn:0  state:48  yychar:311
reduce
state 48, reducing 1 by rule 54 (equality_expression : relational_expression)
reduce
after reduction, shifting from state 85 to state 49
loop
yyn:0  state:49  yychar:311
reduce
state 49, reducing 1 by rule 57 (logical_and_expression : equality_expression)
reduce
after reduction, shifting from state 85 to state 50
loop
yyn:0  state:50  yychar:311
reduce
state 50, reducing 1 by rule 59 (logical_or_expression : logical_and_expression)
reduce
after reduction, shifting from state 85 to state 51
loop
yyn:0  state:51  yychar:311
reduce
state 51, reducing 1 by rule 74 (expression_t : logical_or_expression)
reduce
after reduction, shifting from state 85 to state 52
loop
state 52, reducing 1 by rule 72 (expression : expression_t)
reduce
after reduction, shifting from state 85 to state 131
loop
state 131, reducing 1 by rule 36 (param : expression)
reduce
after reduction, shifting from state 85 to state 132
loop
state 132, reducing 3 by rule 34 (params : params commaq param)
reduce
after reduction, shifting from state 64 to state 99
loop
yyn:0  state:99  yychar:311
reduce
state 99, reducing 0 by rule 14 (commaq :)
reduce
after reduction, shifting from state 99 to state 85
loop
yyn:0  state:85  yychar:311
state 85, shifting to state 35
loop
state 35, reducing 1 by rule 11 (atom : NUMERIC)
reduce
after reduction, shifting from state 85 to state 37
loop
state 37, reducing 1 by rule 21 (primary_expression : atom)
reduce
after reduction, shifting from state 85 to state 39
loop
state 39, reducing 1 by rule 29 (postfix_expression : primary_expression)
reduce
after reduction, shifting from state 85 to state 42
loop
yyn:0  state:42  yychar:-1
 next yychar:304
reduce
state 42, reducing 1 by rule 37 (unary_expression : postfix_expression)
reduce
after reduction, shifting from state 85 to state 44
loop
state 44, reducing 1 by rule 47 (pow_expression : unary_expression)
reduce
after reduction, shifting from state 85 to state 47
loop
yyn:0  state:47  yychar:304
reduce
state 47, reducing 1 by rule 46 (multiplicative_expression : pow_expression)
reduce
after reduction, shifting from state 85 to state 46
loop
yyn:0  state:46  yychar:304
reduce
state 46, reducing 1 by rule 40 (additive_expression : multiplicative_expression)
reduce
after reduction, shifting from state 85 to state 45
loop
yyn:0  state:45  yychar:304
reduce
state 45, reducing 1 by rule 49 (relational_expression : additive_expression)
reduce
after reduction, shifting from state 85 to state 48
loop
yyn:0  state:48  yychar:304
reduce
state 48, reducing 1 by rule 54 (equality_expression : relational_expression)
reduce
after reduction, shifting from state 85 to state 49
loop
yyn:0  state:49  yychar:304
reduce
state 49, reducing 1 by rule 57 (logical_and_expression : equality_expression)
reduce
after reduction, shifting from state 85 to state 50
loop
yyn:0  state:50  yychar:304
reduce
state 50, reducing 1 by rule 59 (logical_or_expression : logical_and_expression)
reduce
after reduction, shifting from state 85 to state 51
loop
yyn:0  state:51  yychar:304
reduce
state 51, reducing 1 by rule 74 (expression_t : logical_or_expression)
reduce
after reduction, shifting from state 85 to state 52
loop
state 52, reducing 1 by rule 72 (expression : expression_t)
reduce
after reduction, shifting from state 85 to state 131
loop
state 131, reducing 1 by rule 36 (param : expression)
reduce
after reduction, shifting from state 85 to state 132
loop
state 132, reducing 3 by rule 34 (params : params commaq param)
reduce
after reduction, shifting from state 64 to state 99
loop
yyn:0  state:99  yychar:304
reduce
state 99, reducing 3 by rule 33 (function_expression : IDENTIFIER COLON params)
reduce
after reduction, shifting from state 150 to state 43
loop
state 43, reducing 1 by rule 32 (postfix_expression : function_expression)
reduce
after reduction, shifting from state 150 to state 42
loop
yyn:0  state:42  yychar:304
reduce
state 42, reducing 1 by rule 37 (unary_expression : postfix_expression)
reduce
after reduction, shifting from state 150 to state 44
loop
state 44, reducing 1 by rule 47 (pow_expression : unary_expression)
reduce
after reduction, shifting from state 150 to state 47
loop
yyn:0  state:47  yychar:304
reduce
state 47, reducing 1 by rule 46 (multiplicative_expression : pow_expression)
reduce
after reduction, shifting from state 150 to state 46
loop
yyn:0  state:46  yychar:304
reduce
state 46, reducing 1 by rule 40 (additive_expression : multiplicative_expression)
reduce
after reduction, shifting from state 150 to state 45
loop
yyn:0  state:45  yychar:304
reduce
state 45, reducing 1 by rule 49 (relational_expression : additive_expression)
reduce
after reduction, shifting from state 150 to state 48
loop
yyn:0  state:48  yychar:304
reduce
state 48, reducing 1 by rule 54 (equality_expression : relational_expression)
reduce
after reduction, shifting from state 150 to state 49
loop
yyn:0  state:49  yychar:304
reduce
state 49, reducing 1 by rule 57 (logical_and_expression : equality_expression)
reduce
after reduction, shifting from state 150 to state 50
loop
yyn:0  state:50  yychar:304
reduce
state 50, reducing 1 by rule 59 (logical_or_expression : logical_and_expression)
reduce
after reduction, shifting from state 150 to state 51
loop
yyn:0  state:51  yychar:304
reduce
state 51, reducing 1 by rule 74 (expression_t : logical_or_expression)
reduce
after reduction, shifting from state 150 to state 52
loop
state 52, reducing 1 by rule 72 (expression : expression_t)
reduce
after reduction, shifting from state 150 to state 169
loop
state 169, reducing 3 by rule 61 (assignment_expression : compound_identifier EQUALS expression)
reduce
after reduction, shifting from state 188 to state 123
loop
state 123, reducing 1 by rule 70 (assignment_statement : assignment_expression)
reduce
after reduction, shifting from state 188 to state 128
loop
yyn:0  state:128  yychar:304
state 128, shifting to state 154
loop
state 154, reducing 2 by rule 66 (statement : assignment_statement NEWLINE)
reduce
after reduction, shifting from state 188 to state 124
loop
state 124, reducing 1 by rule 68 (statements : statement)
reduce
after reduction, shifting from state 188 to state 194
loop
yyn:0  state:194  yychar:-1
 next yychar:263
state 194, shifting to state 198
loop
state 198, reducing 8 by rule 81 (iteration_statement : FOREACH identifier in_statement as_statement from_statement NEWLINE statements END)
reduce
after reduction, shifting from state 130 to state 127
loop
yyn:0  state:127  yychar:-1
 next yychar:304
state 127, shifting to state 153
loop
state 153, reducing 2 by rule 64 (statement : iteration_statement NEWLINE)
reduce
after reduction, shifting from state 130 to state 156
loop
state 156, reducing 2 by rule 69 (statements : statements statement)
reduce
after reduction, shifting from state 84 to state 130
loop
yyn:0  state:130  yychar:-1
 next yychar:261
state 130, shifting to state 157
loop
yyn:0  state:157  yychar:-1
 next yychar:308
state 157, shifting to state 32
loop
yyn:0  state:32  yychar:-1
 next yychar:304
reduce
state 32, reducing 1 by rule 28 (compound_identifier : IDENTIFIER)
reduce
after reduction, shifting from state 157 to state 41
loop
yyn:0  state:41  yychar:304
reduce
state 41, reducing 1 by rule 25 (identifier : compound_identifier)
reduce
after reduction, shifting from state 157 to state 40
loop
state 40, reducing 1 by rule 23 (primary_expression : identifier)
reduce
after reduction, shifting from state 157 to state 39
loop
state 39, reducing 1 by rule 29 (postfix_expression : primary_expression)
reduce
after reduction, shifting from state 157 to state 42
loop
yyn:0  state:42  yychar:304
reduce
state 42, reducing 1 by rule 37 (unary_expression : postfix_expression)
reduce
after reduction, shifting from state 157 to state 44
loop
state 44, reducing 1 by rule 47 (pow_expression : unary_expression)
reduce
after reduction, shifting from state 157 to state 47
loop
yyn:0  state:47  yychar:304
reduce
state 47, reducing 1 by rule 46 (multiplicative_expression : pow_expression)
reduce
after reduction, shifting from state 157 to state 46
loop
yyn:0  state:46  yychar:304
reduce
state 46, reducing 1 by rule 40 (additive_expression : multiplicative_expression)
reduce
after reduction, shifting from state 157 to state 45
loop
yyn:0  state:45  yychar:304
reduce
state 45, reducing 1 by rule 49 (relational_expression : additive_expression)
reduce
after reduction, shifting from state 157 to state 48
loop
yyn:0  state:48  yychar:304
reduce
state 48, reducing 1 by rule 54 (equality_expression : relational_expression)
reduce
after reduction, shifting from state 157 to state 49
loop
yyn:0  state:49  yychar:304
reduce
state 49, reducing 1 by rule 57 (logical_and_expression : equality_expression)
reduce
after reduction, shifting from state 157 to state 50
loop
yyn:0  state:50  yychar:304
reduce
state 50, reducing 1 by rule 59 (logical_or_expression : logical_and_expression)
reduce
after reduction, shifting from state 157 to state 51
loop
yyn:0  state:51  yychar:304
reduce
state 51, reducing 1 by rule 74 (expression_t : logical_or_expression)
reduce
after reduction, shifting from state 157 to state 52
loop
state 52, reducing 1 by rule 72 (expression : expression_t)
reduce
after reduction, shifting from state 157 to state 170
loop
yyn:0  state:170  yychar:304
state 170, shifting to state 178
loop
state 178, reducing 3 by rule 94 (opt_return : RETURN expression NEWLINE)
reduce
after reduction, shifting from state 130 to state 158
loop
yyn:0  state:158  yychar:-1
 next yychar:263
state 158, shifting to state 171
loop
state 171, reducing 8 by rule 93 (function_declarator : TO IDENTIFIER COLON params NEWLINE statements opt_return END)
reduce
after reduction, shifting from state 9 to state 11
loop
state 11, reducing 1 by rule 4 (external_declaration : function_declarator)
reduce
after reduction, shifting from state 9 to state 23
loop
state 23, reducing 2 by rule 3 (program_unit : program_unit external_declaration)
reduce
after reduction, shifting from state 0 to state 9
loop
yyn:0  state:9  yychar:-1
 next yychar:304
state 9, shifting to state 6
loop
state 6, reducing 1 by rule 9 (external_declaration : NEWLINE)
reduce
after reduction, shifting from state 9 to state 23
loop
state 23, reducing 2 by rule 3 (program_unit : program_unit external_declaration)
reduce
after reduction, shifting from state 0 to state 9
loop
yyn:0  state:9  yychar:-1
 next yychar:304
state 9, shifting to state 6
loop
state 6, reducing 1 by rule 9 (external_declaration : NEWLINE)
reduce
after reduction, shifting from state 9 to state 23
loop
state 23, reducing 2 by rule 3 (program_unit : program_unit external_declaration)
reduce
after reduction, shifting from state 0 to state 9
loop
yyn:0  state:9  yychar:-1
 next yychar:257
state 9, shifting to state 1
loop
yyn:0  state:1  yychar:-1
 next yychar:308
state 1, shifting to state 17
loop
yyn:0  state:17  yychar:-1
 next yychar:298
state 17, shifting to state 25
loop
state 25, reducing 0 by rule 35 (params :)
reduce
after reduction, shifting from state 25 to state 54
loop
yyn:0  state:54  yychar:-1
 next yychar:308
reduce
state 54, reducing 0 by rule 14 (commaq :)
reduce
after reduction, shifting from state 54 to state 85
loop
yyn:0  state:85  yychar:308
state 85, shifting to state 32
loop
yyn:0  state:32  yychar:-1
 next yychar:304
reduce
state 32, reducing 1 by rule 28 (compound_identifier : IDENTIFIER)
reduce
after reduction, shifting from state 85 to state 41
loop
yyn:0  state:41  yychar:304
reduce
state 41, reducing 1 by rule 25 (identifier : compound_identifier)
reduce
after reduction, shifting from state 85 to state 40
loop
state 40, reducing 1 by rule 23 (primary_expression : identifier)
reduce
after reduction, shifting from state 85 to state 39
loop
state 39, reducing 1 by rule 29 (postfix_expression : primary_expression)
reduce
after reduction, shifting from state 85 to state 42
loop
yyn:0  state:42  yychar:304
reduce
state 42, reducing 1 by rule 37 (unary_expression : postfix_expression)
reduce
after reduction, shifting from state 85 to state 44
loop
state 44, reducing 1 by rule 47 (pow_expression : unary_expression)
reduce
after reduction, shifting from state 85 to state 47
loop
yyn:0  state:47  yychar:304
reduce
state 47, reducing 1 by rule 46 (multiplicative_expression : pow_expression)
reduce
after reduction, shifting from state 85 to state 46
loop
yyn:0  state:46  yychar:304
reduce
state 46, reducing 1 by rule 40 (additive_expression : multiplicative_expression)
reduce
after reduction, shifting from state 85 to state 45
loop
yyn:0  state:45  yychar:304
reduce
state 45, reducing 1 by rule 49 (relational_expression : additive_expression)
reduce
after reduction, shifting from state 85 to state 48
loop
yyn:0  state:48  yychar:304
reduce
state 48, reducing 1 by rule 54 (equality_expression : relational_expression)
reduce
after reduction, shifting from state 85 to state 49
loop
yyn:0  state:49  yychar:304
reduce
state 49, reducing 1 by rule 57 (logical_and_expression : equality_expression)
reduce
after reduction, shifting from state 85 to state 50
loop
yyn:0  state:50  yychar:304
reduce
state 50, reducing 1 by rule 59 (logical_or_expression : logical_and_expression)
reduce
after reduction, shifting from state 85 to state 51
loop
yyn:0  state:51  yychar:304
reduce
state 51, reducing 1 by rule 74 (expression_t : logical_or_expression)
reduce
after reduction, shifting from state 85 to state 52
loop
state 52, reducing 1 by rule 72 (expression : expression_t)
reduce
after reduction, shifting from state 85 to state 131
loop
state 131, reducing 1 by rule 36 (param : expression)
reduce
after reduction, shifting from state 85 to state 132
loop
state 132, reducing 3 by rule 34 (params : params commaq param)
reduce
after reduction, shifting from state 25 to state 54
loop
yyn:0  state:54  yychar:304
state 54, shifting to state 84
loop
yyn:0  state:84  yychar:-1
 next yychar:265
state 84, shifting to state 3
loop
yyn:0  state:3  yychar:-1
 next yychar:308
state 3, shifting to state 19
loop
yyn:0  state:19  yychar:-1
 next yychar:292
state 19, shifting to state 27
loop
yyn:0  state:27  yychar:-1
 next yychar:311
state 27, shifting to state 35
loop
state 35, reducing 1 by rule 11 (atom : NUMERIC)
reduce
after reduction, shifting from state 27 to state 37
loop
state 37, reducing 1 by rule 21 (primary_expression : atom)
reduce
after reduction, shifting from state 27 to state 39
loop
state 39, reducing 1 by rule 29 (postfix_expression : primary_expression)
reduce
after reduction, shifting from state 27 to state 42
loop
yyn:0  state:42  yychar:-1
 next yychar:304
reduce
state 42, reducing 1 by rule 37 (unary_expression : postfix_expression)
reduce
after reduction, shifting from state 27 to state 44
loop
state 44, reducing 1 by rule 47 (pow_expression : unary_expression)
reduce
after reduction, shifting from state 27 to state 47
loop
yyn:0  state:47  yychar:304
reduce
state 47, reducing 1 by rule 46 (multiplicative_expression : pow_expression)
reduce
after reduction, shifting from state 27 to state 46
loop
yyn:0  state:46  yychar:304
reduce
state 46, reducing 1 by rule 40 (additive_expression : multiplicative_expression)
reduce
after reduction, shifting from state 27 to state 45
loop
yyn:0  state:45  yychar:304
reduce
state 45, reducing 1 by rule 49 (relational_expression : additive_expression)
reduce
after reduction, shifting from state 27 to state 48
loop
yyn:0  state:48  yychar:304
reduce
state 48, reducing 1 by rule 54 (equality_expression : relational_expression)
reduce
after reduction, shifting from state 27 to state 49
loop
yyn:0  state:49  yychar:304
reduce
state 49, reducing 1 by rule 57 (logical_and_expression : equality_expression)
reduce
after reduction, shifting from state 27 to state 50
loop
yyn:0  state:50  yychar:304
reduce
state 50, reducing 1 by rule 59 (logical_or_expression : logical_and_expression)
reduce
after reduction, shifting from state 27 to state 51
loop
yyn:0  state:51  yychar:304
reduce
state 51, reducing 1 by rule 74 (expression_t : logical_or_expression)
reduce
after reduction, shifting from state 27 to state 52
loop
state 52, reducing 1 by rule 72 (expression : expression_t)
reduce
after reduction, shifting from state 27 to state 56
loop
state 56, reducing 3 by rule 100 (declarator : IDENTIFIER EQUALS expression)
reduce
after reduction, shifting from state 3 to state 21
loop
state 21, reducing 1 by rule 97 (declaration_list : declarator)
reduce
after reduction, shifting from state 3 to state 20
loop
yyn:0  state:20  yychar:304
reduce
state 20, reducing 2 by rule 96 (var_declarator : VAR declaration_list)
reduce
after reduction, shifting from state 84 to state 120
loop
yyn:0  state:120  yychar:304
state 120, shifting to state 149
loop
state 149, reducing 2 by rule 65 (statement : var_declarator NEWLINE)
reduce
after reduction, shifting from state 84 to state 124
loop
state 124, reducing 1 by rule 68 (statements : statement)
reduce
after reduction, shifting from state 84 to state 130
loop
yyn:0  state:130  yychar:-1
 next yychar:265
state 130, shifting to state 3
loop
yyn:0  state:3  yychar:-1
 next yychar:308
state 3, shifting to state 19
loop
yyn:0  state:19  yychar:-1
 next yychar:299
reduce
state 19, reducing 1 by rule 99 (declarator : IDENTIFIER)
reduce
after reduction, shifting from state 3 to state 21
loop
state 21, reducing 1 by rule 97 (declaration_list : declarator)
reduce
after reduction, shifting from state 3 to state 20
loop
yyn:0  state:20  yychar:299
state 20, shifting to state 28
loop
yyn:0  state:28  yychar:-1
 next yychar:308
state 28, shifting to state 19
loop
yyn:0  state:19  yychar:-1
 next yychar:299
reduce
state 19, reducing 1 by rule 99 (declarator : IDENTIFIER)
reduce
after reduction, shifting from state 28 to state 57
loop
state 57, reducing 3 by rule 98 (declaration_list : declaration_list COMMA declarator)
reduce
after reduction, shifting from state 3 to state 20
loop
yyn:0  state:20  yychar:299
state 20, shifting to state 28
loop
yyn:0  state:28  yychar:-1
 next yychar:308
state 28, shifting to state 19
loop
yyn:0  state:19  yychar:-1
 next yychar:299
reduce
state 19, reducing 1 by rule 99 (declarator : IDENTIFIER)
reduce
after reduction, shifting from state 28 to state 57
loop
state 57, reducing 3 by rule 98 (declaration_list : declaration_list COMMA declarator)
reduce
after reduction, shifting from state 3 to state 20
loop
yyn:0  state:20  yychar:299
state 20, shifting to state 28
loop
yyn:0  state:28  yychar:-1
 next yychar:308
state 28, shifting to state 19
loop
yyn:0  state:19  yychar:-1
 next yychar:304
reduce
state 19, reducing 1 by rule 99 (declarator : IDENTIFIER)
reduce
after reduction, shifting from state 28 to state 57
loop
state 57, reducing 3 by rule 98 (declaration_list : declaration_list COMMA declarator)
reduce
after reduction, shifting from state 3 to state 20
loop
yyn:0  state:20  yychar:304
reduce
state 20, reducing 2 by rule 96 (var_declarator : VAR declaration_list)
reduce
after reduction, shifting from state 130 to state 120
loop
yyn:0  state:120  yychar:304
state 120, shifting to state 149
loop
state 149, reducing 2 by rule 65 (statement : var_declarator NEWLINE)
reduce
after reduction, shifting from state 130 to state 156
loop
state 156, reducing 2 by rule 69 (statements : statements statement)
reduce
after reduction, shifting from state 84 to state 130
loop
yyn:0  state:130  yychar:-1
 next yychar:304
state 130, shifting to state 119
loop
state 119, reducing 1 by rule 67 (statement : NEWLINE)
reduce
after reduction, shifting from state 130 to state 156
loop
state 156, reducing 2 by rule 69 (statements : statements statement)
reduce
after reduction, shifting from state 84 to state 130
loop
yyn:0  state:130  yychar:-1
 next yychar:258
state 130, shifting to state 115
loop
yyn:0  state:115  yychar:-1
 next yychar:308
state 115, shifting to state 88
loop
state 88, reducing 1 by rule 28 (compound_identifier : IDENTIFIER)
reduce
after reduction, shifting from state 115 to state 41
loop
yyn:0  state:41  yychar:-1
 next yychar:270
reduce
state 41, reducing 1 by rule 25 (identifier : compound_identifier)
reduce
after reduction, shifting from state 115 to state 144
loop
yyn:0  state:144  yychar:270
state 144, shifting to state 163
loop
yyn:0  state:163  yychar:-1
 next yychar:311
state 163, shifting to state 35
loop
state 35, reducing 1 by rule 11 (atom : NUMERIC)
reduce
after reduction, shifting from state 163 to state 37
loop
state 37, reducing 1 by rule 21 (primary_expression : atom)
reduce
after reduction, shifting from state 163 to state 39
loop
state 39, reducing 1 by rule 29 (postfix_expression : primary_expression)
reduce
after reduction, shifting from state 163 to state 42
loop
yyn:0  state:42  yychar:-1
 next yychar:257
reduce
state 42, reducing 1 by rule 37 (unary_expression : postfix_expression)
reduce
after reduction, shifting from state 163 to state 44
loop
state 44, reducing 1 by rule 47 (pow_expression : unary_expression)
reduce
after reduction, shifting from state 163 to state 47
loop
yyn:0  state:47  yychar:257
reduce
state 47, reducing 1 by rule 46 (multiplicative_expression : pow_expression)
reduce
after reduction, shifting from state 163 to state 46
loop
yyn:0  state:46  yychar:257
reduce
state 46, reducing 1 by rule 40 (additive_expression : multiplicative_expression)
reduce
after reduction, shifting from state 163 to state 45
loop
yyn:0  state:45  yychar:257
reduce
state 45, reducing 1 by rule 49 (relational_expression : additive_expression)
reduce
after reduction, shifting from state 163 to state 48
loop
yyn:0  state:48  yychar:257
reduce
state 48, reducing 1 by rule 54 (equality_expression : relational_expression)
reduce
after reduction, shifting from state 163 to state 49
loop
yyn:0  state:49  yychar:257
reduce
state 49, reducing 1 by rule 57 (logical_and_expression : equality_expression)
reduce
after reduction, shifting from state 163 to state 50
loop
yyn:0  state:50  yychar:257
reduce
state 50, reducing 1 by rule 59 (logical_or_expression : logical_and_expression)
reduce
after reduction, shifting from state 163 to state 51
loop
yyn:0  state:51  yychar:257
reduce
state 51, reducing 1 by rule 74 (expression_t : logical_or_expression)
reduce
after reduction, shifting from state 163 to state 52
loop
state 52, reducing 1 by rule 72 (expression : expression_t)
reduce
after reduction, shifting from state 163 to state 172
loop
yyn:0  state:172  yychar:257
state 172, shifting to state 179
loop
yyn:0  state:179  yychar:-1
 next yychar:311
state 179, shifting to state 35
loop
state 35, reducing 1 by rule 11 (atom : NUMERIC)
reduce
after reduction, shifting from state 179 to state 37
loop
state 37, reducing 1 by rule 21 (primary_expression : atom)
reduce
after reduction, shifting from state 179 to state 39
loop
state 39, reducing 1 by rule 29 (postfix_expression : primary_expression)
reduce
after reduction, shifting from state 179 to state 42
loop
yyn:0  state:42  yychar:-1
 next yychar:304
reduce
state 42, reducing 1 by rule 37 (unary_expression : postfix_expression)
reduce
after reduction, shifting from state 179 to state 44
loop
state 44, reducing 1 by rule 47 (pow_expression : unary_expression)
reduce
after reduction, shifting from state 179 to state 47
loop
yyn:0  state:47  yychar:304
reduce
state 47, reducing 1 by rule 46 (multiplicative_expression : pow_expression)
reduce
after reduction, shifting from state 179 to state 46
loop
yyn:0  state:46  yychar:304
reduce
state 46, reducing 1 by rule 40 (additive_expression : multiplicative_expression)
reduce
after reduction, shifting from state 179 to state 45
loop
yyn:0  state:45  yychar:304
reduce
state 45, reducing 1 by rule 49 (relational_expression : additive_expression)
reduce
after reduction, shifting from state 179 to state 48
loop
yyn:0  state:48  yychar:304
reduce
state 48, reducing 1 by rule 54 (equality_expression : relational_expression)
reduce
after reduction, shifting from state 179 to state 49
loop
yyn:0  state:49  yychar:304
reduce
state 49, reducing 1 by rule 57 (logical_and_expression : equality_expression)
reduce
after reduction, shifting from state 179 to state 50
loop
yyn:0  state:50  yychar:304
reduce
state 50, reducing 1 by rule 59 (logical_or_expression : logical_and_expression)
reduce
after reduction, shifting from state 179 to state 51
loop
yyn:0  state:51  yychar:304
reduce
state 51, reducing 1 by rule 74 (expression_t : logical_or_expression)
reduce
after reduction, shifting from state 179 to state 52
loop
state 52, reducing 1 by rule 72 (expression : expression_t)
reduce
after reduction, shifting from state 179 to state 186
loop
yyn:0  state:186  yychar:304
reduce
state 186, reducing 0 by rule 89 (by_statement :)
reduce
after reduction, shifting from state 186 to state 192
loop
yyn:0  state:192  yychar:304
state 192, shifting to state 196
loop
yyn:0  state:196  yychar:-1
 next yychar:304
state 196, shifting to state 119
loop
state 119, reducing 1 by rule 67 (statement : NEWLINE)
reduce
after reduction, shifting from state 196 to state 124
loop
state 124, reducing 1 by rule 68 (statements : statement)
reduce
after reduction, shifting from state 196 to state 199
loop
yyn:0  state:199  yychar:-1
 next yychar:308
state 199, shifting to state 32
loop
yyn:0  state:32  yychar:-1
 next yychar:292
reduce
state 32, reducing 1 by rule 28 (compound_identifier : IDENTIFIER)
reduce
after reduction, shifting from state 199 to state 122
loop
yyn:0  state:122  yychar:292
state 122, shifting to state 150
loop
yyn:0  state:150  yychar:-1
 next yychar:308
state 150, shifting to state 32
loop
yyn:0  state:32  yychar:-1
 next yychar:298
state 32, shifting to state 64
loop
state 64, reducing 0 by rule 35 (params :)
reduce
after reduction, shifting from state 64 to state 99
loop
yyn:0  state:99  yychar:-1
 next yychar:308
reduce
state 99, reducing 0 by rule 14 (commaq :)
reduce
after reduction, shifting from state 99 to state 85
loop
yyn:0  state:85  yychar:308
state 85, shifting to state 32
loop
yyn:0  state:32  yychar:-1
 next yychar:299
reduce
state 32, reducing 1 by rule 28 (compound_identifier : IDENTIFIER)
reduce
after reduction, shifting from state 85 to state 41
loop
yyn:0  state:41  yychar:299
reduce
state 41, reducing 1 by rule 25 (identifier : compound_identifier)
reduce
after reduction, shifting from state 85 to state 40
loop
state 40, reducing 1 by rule 23 (primary_expression : identifier)
reduce
after reduction, shifting from state 85 to state 39
loop
state 39, reducing 1 by rule 29 (postfix_expression : primary_expression)
reduce
after reduction, shifting from state 85 to state 42
loop
yyn:0  state:42  yychar:299
reduce
state 42, reducing 1 by rule 37 (unary_expression : postfix_expression)
reduce
after reduction, shifting from state 85 to state 44
loop
state 44, reducing 1 by rule 47 (pow_expression : unary_expression)
reduce
after reduction, shifting from state 85 to state 47
loop
yyn:0  state:47  yychar:299
reduce
state 47, reducing 1 by rule 46 (multiplicative_expression : pow_expression)
reduce
after reduction, shifting from state 85 to state 46
loop
yyn:0  state:46  yychar:299
reduce
state 46, reducing 1 by rule 40 (additive_expression : multiplicative_expression)
reduce
after reduction, shifting from state 85 to state 45
loop
yyn:0  state:45  yychar:299
reduce
state 45, reducing 1 by rule 49 (relational_expression : additive_expression)
reduce
after reduction, shifting from state 85 to state 48
loop
yyn:0  state:48  yychar:299
reduce
state 48, reducing 1 by rule 54 (equality_expression : relational_expression)
reduce
after reduction, shifting from state 85 to state 49
loop
yyn:0  state:49  yychar:299
reduce
state 49, reducing 1 by rule 57 (logical_and_expression : equality_expression)
reduce
after reduction, shifting from state 85 to state 50
loop
yyn:0  state:50  yychar:299
reduce
state 50, reducing 1 by rule 59 (logical_or_expression : logical_and_expression)
reduce
after reduction, shifting from state 85 to state 51
loop
yyn:0  state:51  yychar:299
reduce
state 51, reducing 1 by rule 74 (expression_t : logical_or_expression)
reduce
after reduction, shifting from state 85 to state 52
loop
state 52, reducing 1 by rule 72 (expression : expression_t)
reduce
after reduction, shifting from state 85 to state 131
loop
state 131, reducing 1 by rule 36 (param : expression)
reduce
after reduction, shifting from state 85 to state 132
loop
state 132, reducing 3 by rule 34 (params : params commaq param)
reduce
after reduction, shifting from state 64 to state 99
loop
yyn:0  state:99  yychar:299
state 99, shifting to state 83
loop
state 83, reducing 1 by rule 13 (commaq : COMMA)
reduce
after reduction, shifting from state 99 to state 85
loop
yyn:0  state:85  yychar:-1
 next yychar:308
state 85, shifting to state 32
loop
yyn:0  state:32  yychar:-1
 next yychar:300
reduce
state 32, reducing 1 by rule 28 (compound_identifier : IDENTIFIER)
reduce
after reduction, shifting from state 85 to state 41
loop
yyn:0  state:41  yychar:300
state 41, shifting to state 65
loop
yyn:0  state:65  yychar:-1
 next yychar:308
state 65, shifting to state 100
loop
state 100, reducing 3 by rule 27 (compound_identifier : compound_identifier DOT IDENTIFIER)
reduce
after reduction, shifting from state 85 to state 41
loop
yyn:0  state:41  yychar:-1
 next yychar:304
reduce
state 41, reducing 1 by rule 25 (identifier : compound_identifier)
reduce
after reduction, shifting from state 85 to state 40
loop
state 40, reducing 1 by rule 23 (primary_expression : identifier)
reduce
after reduction, shifting from state 85 to state 39
loop
state 39, reducing 1 by rule 29 (postfix_expression : primary_expression)
reduce
after reduction, shifting from state 85 to state 42
loop
yyn:0  state:42  yychar:304
reduce
state 42, reducing 1 by rule 37 (unary_expression : postfix_expression)
reduce
after reduction, shifting from state 85 to state 44
loop
state 44, reducing 1 by rule 47 (pow_expression : unary_expression)
reduce
after reduction, shifting from state 85 to state 47
loop
yyn:0  state:47  yychar:304
reduce
state 47, reducing 1 by rule 46 (multiplicative_expression : pow_expression)
reduce
after reduction, shifting from state 85 to state 46
loop
yyn:0  state:46  yychar:304
reduce
state 46, reducing 1 by rule 40 (additive_expression : multiplicative_expression)
reduce
after reduction, shifting from state 85 to state 45
loop
yyn:0  state:45  yychar:304
reduce
state 45, reducing 1 by rule 49 (relational_expression : additive_expression)
reduce
after reduction, shifting from state 85 to state 48
loop
yyn:0  state:48  yychar:304
reduce
state 48, reducing 1 by rule 54 (equality_expression : relational_expression)
reduce
after reduction, shifting from state 85 to state 49
loop
yyn:0  state:49  yychar:304
reduce
state 49, reducing 1 by rule 57 (logical_and_expression : equality_expression)
reduce
after reduction, shifting from state 85 to state 50
loop
yyn:0  state:50  yychar:304
reduce
state 50, reducing 1 by rule 59 (logical_or_expression : logical_and_expression)
reduce
after reduction, shifting from state 85 to state 51
loop
yyn:0  state:51  yychar:304
reduce
state 51, reducing 1 by rule 74 (expression_t : logical_or_expression)
reduce
after reduction, shifting from state 85 to state 52
loop
state 52, reducing 1 by rule 72 (expression : expression_t)
reduce
after reduction, shifting from state 85 to state 131
loop
state 131, reducing 1 by rule 36 (param : expression)
reduce
after reduction, shifting from state 85 to state 132
loop
state 132, reducing 3 by rule 34 (params : params commaq param)
reduce
after reduction, shifting from state 64 to state 99
loop
yyn:0  state:99  yychar:304
reduce
state 99, reducing 3 by rule 33 (function_expression : IDENTIFIER COLON params)
reduce
after reduction, shifting from state 150 to state 43
loop
state 43, reducing 1 by rule 32 (postfix_expression : function_expression)
reduce
after reduction, shifting from state 150 to state 42
loop
yyn:0  state:42  yychar:304
reduce
state 42, reducing 1 by rule 37 (unary_expression : postfix_expression)
reduce
after reduction, shifting from state 150 to state 44
loop
state 44, reducing 1 by rule 47 (pow_expression : unary_expression)
reduce
after reduction, shifting from state 150 to state 47
loop
yyn:0  state:47  yychar:304
reduce
state 47, reducing 1 by rule 46 (multiplicative_expression : pow_expression)
reduce
after reduction, shifting from state 150 to state 46
loop
yyn:0  state:46  yychar:304
reduce
state 46, reducing 1 by rule 40 (additive_expression : multiplicative_expression)
reduce
after reduction, shifting from state 150 to state 45
loop
yyn:0  state:45  yychar:304
reduce
state 45, reducing 1 by rule 49 (relational_expression : additive_expression)
reduce
after reduction, shifting from state 150 to state 48
loop
yyn:0  state:48  yychar:304
reduce
state 48, reducing 1 by rule 54 (equality_expression : relational_expression)
reduce
after reduction, shifting from state 150 to state 49
loop
yyn:0  state:49  yychar:304
reduce
state 49, reducing 1 by rule 57 (logical_and_expression : equality_expression)
reduce
after reduction, shifting from state 150 to state 50
loop
yyn:0  state:50  yychar:304
reduce
state 50, reducing 1 by rule 59 (logical_or_expression : logical_and_expression)
reduce
after reduction, shifting from state 150 to state 51
loop
yyn:0  state:51  yychar:304
reduce
state 51, reducing 1 by rule 74 (expression_t : logical_or_expression)
reduce
after reduction, shifting from state 150 to state 52
loop
state 52, reducing 1 by rule 72 (expression : expression_t)
reduce
after reduction, shifting from state 150 to state 169
loop
state 169, reducing 3 by rule 61 (assignment_expression : compound_identifier EQUALS expression)
reduce
after reduction, shifting from state 199 to state 123
loop
state 123, reducing 1 by rule 70 (assignment_statement : assignment_expression)
reduce
after reduction, shifting from state 199 to state 128
loop
yyn:0  state:128  yychar:304
state 128, shifting to state 154
loop
state 154, reducing 2 by rule 66 (statement : assignment_statement NEWLINE)
reduce
after reduction, shifting from state 199 to state 156
loop
state 156, reducing 2 by rule 69 (statements : statements statement)
reduce
after reduction, shifting from state 196 to state 199
loop
yyn:0  state:199  yychar:-1
 next yychar:304
state 199, shifting to state 119
loop
state 119, reducing 1 by rule 67 (statement : NEWLINE)
reduce
after reduction, shifting from state 199 to state 156
loop
state 156, reducing 2 by rule 69 (statements : statements statement)
reduce
after reduction, shifting from state 196 to state 199
loop
yyn:0  state:199  yychar:-1
 next yychar:258
state 199, shifting to state 115
loop
yyn:0  state:115  yychar:-1
 next yychar:308
state 115, shifting to state 88
loop
state 88, reducing 1 by rule 28 (compound_identifier : IDENTIFIER)
reduce
after reduction, shifting from state 115 to state 41
loop
yyn:0  state:41  yychar:-1
 next yychar:270
reduce
state 41, reducing 1 by rule 25 (identifier : compound_identifier)
reduce
after reduction, shifting from state 115 to state 144
loop
yyn:0  state:144  yychar:270
state 144, shifting to state 163
loop
yyn:0  state:163  yychar:-1
 next yychar:311
state 163, shifting to state 35
loop
state 35, reducing 1 by rule 11 (atom : NUMERIC)
reduce
after reduction, shifting from state 163 to state 37
loop
state 37, reducing 1 by rule 21 (primary_expression : atom)
reduce
after reduction, shifting from state 163 to state 39
loop
state 39, reducing 1 by rule 29 (postfix_expression : primary_expression)
reduce
after reduction, shifting from state 163 to state 42
loop
yyn:0  state:42  yychar:-1
 next yychar:257
reduce
state 42, reducing 1 by rule 37 (unary_expression : postfix_expression)
reduce
after reduction, shifting from state 163 to state 44
loop
state 44, reducing 1 by rule 47 (pow_expression : unary_expression)
reduce
after reduction, shifting from state 163 to state 47
loop
yyn:0  state:47  yychar:257
reduce
state 47, reducing 1 by rule 46 (multiplicative_expression : pow_expression)
reduce
after reduction, shifting from state 163 to state 46
loop
yyn:0  state:46  yychar:257
reduce
state 46, reducing 1 by rule 40 (additive_expression : multiplicative_expression)
reduce
after reduction, shifting from state 163 to state 45
loop
yyn:0  state:45  yychar:257
reduce
state 45, reducing 1 by rule 49 (relational_expression : additive_expression)
reduce
after reduction, shifting from state 163 to state 48
loop
yyn:0  state:48  yychar:257
reduce
state 48, reducing 1 by rule 54 (equality_expression : relational_expression)
reduce
after reduction, shifting from state 163 to state 49
loop
yyn:0  state:49  yychar:257
reduce
state 49, reducing 1 by rule 57 (logical_and_expression : equality_expression)
reduce
after reduction, shifting from state 163 to state 50
loop
yyn:0  state:50  yychar:257
reduce
state 50, reducing 1 by rule 59 (logical_or_expression : logical_and_expression)
reduce
after reduction, shifting from state 163 to state 51
loop
yyn:0  state:51  yychar:257
reduce
state 51, reducing 1 by rule 74 (expression_t : logical_or_expression)
reduce
after reduction, shifting from state 163 to state 52
loop
state 52, reducing 1 by rule 72 (expression : expression_t)
reduce
after reduction, shifting from state 163 to state 172
loop
yyn:0  state:172  yychar:257
state 172, shifting to state 179
loop
yyn:0  state:179  yychar:-1
 next yychar:311
state 179, shifting to state 35
loop
state 35, reducing 1 by rule 11 (atom : NUMERIC)
reduce
after reduction, shifting from state 179 to state 37
loop
state 37, reducing 1 by rule 21 (primary_expression : atom)
reduce
after reduction, shifting from state 179 to state 39
loop
state 39, reducing 1 by rule 29 (postfix_expression : primary_expression)
reduce
after reduction, shifting from state 179 to state 42
loop
yyn:0  state:42  yychar:-1
 next yychar:304
reduce
state 42, reducing 1 by rule 37 (unary_expression : postfix_expression)
reduce
after reduction, shifting from state 179 to state 44
loop
state 44, reducing 1 by rule 47 (pow_expression : unary_expression)
reduce
after reduction, shifting from state 179 to state 47
loop
yyn:0  state:47  yychar:304
reduce
state 47, reducing 1 by rule 46 (multiplicative_expression : pow_expression)
reduce
after reduction, shifting from state 179 to state 46
loop
yyn:0  state:46  yychar:304
reduce
state 46, reducing 1 by rule 40 (additive_expression : multiplicative_expression)
reduce
after reduction, shifting from state 179 to state 45
loop
yyn:0  state:45  yychar:304
reduce
state 45, reducing 1 by rule 49 (relational_expression : additive_expression)
reduce
after reduction, shifting from state 179 to state 48
loop
yyn:0  state:48  yychar:304
reduce
state 48, reducing 1 by rule 54 (equality_expression : relational_expression)
reduce
after reduction, shifting from state 179 to state 49
loop
yyn:0  state:49  yychar:304
reduce
state 49, reducing 1 by rule 57 (logical_and_expression : equality_expression)
reduce
after reduction, shifting from state 179 to state 50
loop
yyn:0  state:50  yychar:304
reduce
state 50, reducing 1 by rule 59 (logical_or_expression : logical_and_expression)
reduce
after reduction, shifting from state 179 to state 51
loop
yyn:0  state:51  yychar:304
reduce
state 51, reducing 1 by rule 74 (expression_t : logical_or_expression)
reduce
after reduction, shifting from state 179 to state 52
loop
state 52, reducing 1 by rule 72 (expression : expression_t)
reduce
after reduction, shifting from state 179 to state 186
loop
yyn:0  state:186  yychar:304
reduce
state 186, reducing 0 by rule 89 (by_statement :)
reduce
after reduction, shifting from state 186 to state 192
loop
yyn:0  state:192  yychar:304
state 192, shifting to state 196
loop
yyn:0  state:196  yychar:-1
 next yychar:308
state 196, shifting to state 32
loop
yyn:0  state:32  yychar:-1
 next yychar:292
reduce
state 32, reducing 1 by rule 28 (compound_identifier : IDENTIFIER)
reduce
after reduction, shifting from state 196 to state 122
loop
yyn:0  state:122  yychar:292
state 122, shifting to state 150
loop
yyn:0  state:150  yychar:-1
 next yychar:308
state 150, shifting to state 32
loop
yyn:0  state:32  yychar:-1
 next yychar:298
state 32, shifting to state 64
loop
state 64, reducing 0 by rule 35 (params :)
reduce
after reduction, shifting from state 64 to state 99
loop
yyn:0  state:99  yychar:-1
 next yychar:308
reduce
state 99, reducing 0 by rule 14 (commaq :)
reduce
after reduction, shifting from state 99 to state 85
loop
yyn:0  state:85  yychar:308
state 85, shifting to state 32
loop
yyn:0  state:32  yychar:-1
 next yychar:299
reduce
state 32, reducing 1 by rule 28 (compound_identifier : IDENTIFIER)
reduce
after reduction, shifting from state 85 to state 41
loop
yyn:0  state:41  yychar:299
reduce
state 41, reducing 1 by rule 25 (identifier : compound_identifier)
reduce
after reduction, shifting from state 85 to state 40
loop
state 40, reducing 1 by rule 23 (primary_expression : identifier)
reduce
after reduction, shifting from state 85 to state 39
loop
state 39, reducing 1 by rule 29 (postfix_expression : primary_expression)
reduce
after reduction, shifting from state 85 to state 42
loop
yyn:0  state:42  yychar:299
reduce
state 42, reducing 1 by rule 37 (unary_expression : postfix_expression)
reduce
after reduction, shifting from state 85 to state 44
loop
state 44, reducing 1 by rule 47 (pow_expression : unary_expression)
reduce
after reduction, shifting from state 85 to state 47
loop
yyn:0  state:47  yychar:299
reduce
state 47, reducing 1 by rule 46 (multiplicative_expression : pow_expression)
reduce
after reduction, shifting from state 85 to state 46
loop
yyn:0  state:46  yychar:299
reduce
state 46, reducing 1 by rule 40 (additive_expression : multiplicative_expression)
reduce
after reduction, shifting from state 85 to state 45
loop
yyn:0  state:45  yychar:299
reduce
state 45, reducing 1 by rule 49 (relational_expression : additive_expression)
reduce
after reduction, shifting from state 85 to state 48
loop
yyn:0  state:48  yychar:299
reduce
state 48, reducing 1 by rule 54 (equality_expression : relational_expression)
reduce
after reduction, shifting from state 85 to state 49
loop
yyn:0  state:49  yychar:299
reduce
state 49, reducing 1 by rule 57 (logical_and_expression : equality_expression)
reduce
after reduction, shifting from state 85 to state 50
loop
yyn:0  state:50  yychar:299
reduce
state 50, reducing 1 by rule 59 (logical_or_expression : logical_and_expression)
reduce
after reduction, shifting from state 85 to state 51
loop
yyn:0  state:51  yychar:299
reduce
state 51, reducing 1 by rule 74 (expression_t : logical_or_expression)
reduce
after reduction, shifting from state 85 to state 52
loop
state 52, reducing 1 by rule 72 (expression : expression_t)
reduce
after reduction, shifting from state 85 to state 131
loop
state 131, reducing 1 by rule 36 (param : expression)
reduce
after reduction, shifting from state 85 to state 132
loop
state 132, reducing 3 by rule 34 (params : params commaq param)
reduce
after reduction, shifting from state 64 to state 99
loop
yyn:0  state:99  yychar:299
state 99, shifting to state 83
loop
state 83, reducing 1 by rule 13 (commaq : COMMA)
reduce
after reduction, shifting from state 99 to state 85
loop
yyn:0  state:85  yychar:-1
 next yychar:308
state 85, shifting to state 32
loop
yyn:0  state:32  yychar:-1
 next yychar:300
reduce
state 32, reducing 1 by rule 28 (compound_identifier : IDENTIFIER)
reduce
after reduction, shifting from state 85 to state 41
loop
yyn:0  state:41  yychar:300
state 41, shifting to state 65
loop
yyn:0  state:65  yychar:-1
 next yychar:308
state 65, shifting to state 100
loop
state 100, reducing 3 by rule 27 (compound_identifier : compound_identifier DOT IDENTIFIER)
reduce
after reduction, shifting from state 85 to state 41
loop
yyn:0  state:41  yychar:-1
 next yychar:304
reduce
state 41, reducing 1 by rule 25 (identifier : compound_identifier)
reduce
after reduction, shifting from state 85 to state 40
loop
state 40, reducing 1 by rule 23 (primary_expression : identifier)
reduce
after reduction, shifting from state 85 to state 39
loop
state 39, reducing 1 by rule 29 (postfix_expression : primary_expression)
reduce
after reduction, shifting from state 85 to state 42
loop
yyn:0  state:42  yychar:304
reduce
state 42, reducing 1 by rule 37 (unary_expression : postfix_expression)
reduce
after reduction, shifting from state 85 to state 44
loop
state 44, reducing 1 by rule 47 (pow_expression : unary_expression)
reduce
after reduction, shifting from state 85 to state 47
loop
yyn:0  state:47  yychar:304
reduce
state 47, reducing 1 by rule 46 (multiplicative_expression : pow_expression)
reduce
after reduction, shifting from state 85 to state 46
loop
yyn:0  state:46  yychar:304
reduce
state 46, reducing 1 by rule 40 (additive_expression : multiplicative_expression)
reduce
after reduction, shifting from state 85 to state 45
loop
yyn:0  state:45  yychar:304
reduce
state 45, reducing 1 by rule 49 (relational_expression : additive_expression)
reduce
after reduction, shifting from state 85 to state 48
loop
yyn:0  state:48  yychar:304
reduce
state 48, reducing 1 by rule 54 (equality_expression : relational_expression)
reduce
after reduction, shifting from state 85 to state 49
loop
yyn:0  state:49  yychar:304
reduce
state 49, reducing 1 by rule 57 (logical_and_expression : equality_expression)
reduce
after reduction, shifting from state 85 to state 50
loop
yyn:0  state:50  yychar:304
reduce
state 50, reducing 1 by rule 59 (logical_or_expression : logical_and_expression)
reduce
after reduction, shifting from state 85 to state 51
loop
yyn:0  state:51  yychar:304
reduce
state 51, reducing 1 by rule 74 (expression_t : logical_or_expression)
reduce
after reduction, shifting from state 85 to state 52
loop
state 52, reducing 1 by rule 72 (expression : expression_t)
reduce
after reduction, shifting from state 85 to state 131
loop
state 131, reducing 1 by rule 36 (param : expression)
reduce
after reduction, shifting from state 85 to state 132
loop
state 132, reducing 3 by rule 34 (params : params commaq param)
reduce
after reduction, shifting from state 64 to state 99
loop
yyn:0  state:99  yychar:304
reduce
state 99, reducing 3 by rule 33 (function_expression : IDENTIFIER COLON params)
reduce
after reduction, shifting from state 150 to state 43
loop
state 43, reducing 1 by rule 32 (postfix_expression : function_expression)
reduce
after reduction, shifting from state 150 to state 42
loop
yyn:0  state:42  yychar:304
reduce
state 42, reducing 1 by rule 37 (unary_expression : postfix_expression)
reduce
after reduction, shifting from state 150 to state 44
loop
state 44, reducing 1 by rule 47 (pow_expression : unary_expression)
reduce
after reduction, shifting from state 150 to state 47
loop
yyn:0  state:47  yychar:304
reduce
state 47, reducing 1 by rule 46 (multiplicative_expression : pow_expression)
reduce
after reduction, shifting from state 150 to state 46
loop
yyn:0  state:46  yychar:304
reduce
state 46, reducing 1 by rule 40 (additive_expression : multiplicative_expression)
reduce
after reduction, shifting from state 150 to state 45
loop
yyn:0  state:45  yychar:304
reduce
state 45, reducing 1 by rule 49 (relational_expression : additive_expression)
reduce
after reduction, shifting from state 150 to state 48
loop
yyn:0  state:48  yychar:304
reduce
state 48, reducing 1 by rule 54 (equality_expression : relational_expression)
reduce
after reduction, shifting from state 150 to state 49
loop
yyn:0  state:49  yychar:304
reduce
state 49, reducing 1 by rule 57 (logical_and_expression : equality_expression)
reduce
after reduction, shifting from state 150 to state 50
loop
yyn:0  state:50  yychar:304
reduce
state 50, reducing 1 by rule 59 (logical_or_expression : logical_and_expression)
reduce
after reduction, shifting from state 150 to state 51
loop
yyn:0  state:51  yychar:304
reduce
state 51, reducing 1 by rule 74 (expression_t : logical_or_expression)
reduce
after reduction, shifting from state 150 to state 52
loop
state 52, reducing 1 by rule 72 (expression : expression_t)
reduce
after reduction, shifting from state 150 to state 169
loop
state 169, reducing 3 by rule 61 (assignment_expression : compound_identifier EQUALS expression)
reduce
after reduction, shifting from state 196 to state 123
loop
state 123, reducing 1 by rule 70 (assignment_statement : assignment_expression)
reduce
after reduction, shifting from state 196 to state 128
loop
yyn:0  state:128  yychar:304
state 128, shifting to state 154
loop
state 154, reducing 2 by rule 66 (statement : assignment_statement NEWLINE)
reduce
after reduction, shifting from state 196 to state 124
loop
state 124, reducing 1 by rule 68 (statements : statement)
reduce
after reduction, shifting from state 196 to state 199
loop
yyn:0  state:199  yychar:-1
 next yychar:304
state 199, shifting to state 119
loop
state 119, reducing 1 by rule 67 (statement : NEWLINE)
reduce
after reduction, shifting from state 199 to state 156
loop
state 156, reducing 2 by rule 69 (statements : statements statement)
reduce
after reduction, shifting from state 196 to state 199
loop
yyn:0  state:199  yychar:-1
 next yychar:304
state 199, shifting to state 119
loop
state 119, reducing 1 by rule 67 (statement : NEWLINE)
reduce
after reduction, shifting from state 199 to state 156
loop
state 156, reducing 2 by rule 69 (statements : statements statement)
reduce
after reduction, shifting from state 196 to state 199
loop
yyn:0  state:199  yychar:-1
 next yychar:266
state 199, shifting to state 118
loop
yyn:0  state:118  yychar:-1
 next yychar:308
state 118, shifting to state 32
loop
yyn:0  state:32  yychar:-1
 next yychar:292
reduce
state 32, reducing 1 by rule 28 (compound_identifier : IDENTIFIER)
reduce
after reduction, shifting from state 118 to state 41
loop
yyn:0  state:41  yychar:292
reduce
state 41, reducing 1 by rule 25 (identifier : compound_identifier)
reduce
after reduction, shifting from state 118 to state 40
loop
state 40, reducing 1 by rule 23 (primary_expression : identifier)
reduce
after reduction, shifting from state 118 to state 39
loop
state 39, reducing 1 by rule 29 (postfix_expression : primary_expression)
reduce
after reduction, shifting from state 118 to state 42
loop
yyn:0  state:42  yychar:292
reduce
state 42, reducing 1 by rule 37 (unary_expression : postfix_expression)
reduce
after reduction, shifting from state 118 to state 44
loop
state 44, reducing 1 by rule 47 (pow_expression : unary_expression)
reduce
after reduction, shifting from state 118 to state 47
loop
yyn:0  state:47  yychar:292
reduce
state 47, reducing 1 by rule 46 (multiplicative_expression : pow_expression)
reduce
after reduction, shifting from state 118 to state 46
loop
yyn:0  state:46  yychar:292
reduce
state 46, reducing 1 by rule 40 (additive_expression : multiplicative_expression)
reduce
after reduction, shifting from state 118 to state 45
loop
yyn:0  state:45  yychar:292
reduce
state 45, reducing 1 by rule 49 (relational_expression : additive_expression)
reduce
after reduction, shifting from state 118 to state 48
loop
yyn:0  state:48  yychar:292
reduce
state 48, reducing 1 by rule 54 (equality_expression : relational_expression)
reduce
after reduction, shifting from state 118 to state 49
loop
yyn:0  state:49  yychar:292
state 49, shifting to state 79
loop
yyn:0  state:79  yychar:-1
 next yychar:308
state 79, shifting to state 32
loop
yyn:0  state:32  yychar:-1
 next yychar:267
reduce
state 32, reducing 1 by rule 28 (compound_identifier : IDENTIFIER)
reduce
after reduction, shifting from state 79 to state 41
loop
yyn:0  state:41  yychar:267
reduce
state 41, reducing 1 by rule 25 (identifier : compound_identifier)
reduce
after reduction, shifting from state 79 to state 40
loop
state 40, reducing 1 by rule 23 (primary_expression : identifier)
reduce
after reduction, shifting from state 79 to state 39
loop
state 39, reducing 1 by rule 29 (postfix_expression : primary_expression)
reduce
after reduction, shifting from state 79 to state 42
loop
yyn:0  state:42  yychar:267
reduce
state 42, reducing 1 by rule 37 (unary_expression : postfix_expression)
reduce
after reduction, shifting from state 79 to state 44
loop
state 44, reducing 1 by rule 47 (pow_expression : unary_expression)
reduce
after reduction, shifting from state 79 to state 47
loop
yyn:0  state:47  yychar:267
reduce
state 47, reducing 1 by rule 46 (multiplicative_expression : pow_expression)
reduce
after reduction, shifting from state 79 to state 46
loop
yyn:0  state:46  yychar:267
reduce
state 46, reducing 1 by rule 40 (additive_expression : multiplicative_expression)
reduce
after reduction, shifting from state 79 to state 45
loop
yyn:0  state:45  yychar:267
reduce
state 45, reducing 1 by rule 49 (relational_expression : additive_expression)
reduce
after reduction, shifting from state 79 to state 112
loop
yyn:0  state:112  yychar:267
reduce
state 112, reducing 3 by rule 55 (equality_expression : equality_expression EQUALS relational_expression)
reduce
after reduction, shifting from state 118 to state 49
loop
yyn:0  state:49  yychar:267
reduce
state 49, reducing 1 by rule 57 (logical_and_expression : equality_expression)
reduce
after reduction, shifting from state 118 to state 50
loop
yyn:0  state:50  yychar:267
reduce
state 50, reducing 1 by rule 59 (logical_or_expression : logical_and_expression)
reduce
after reduction, shifting from state 118 to state 51
loop
yyn:0  state:51  yychar:267
reduce
state 51, reducing 1 by rule 74 (expression_t : logical_or_expression)
reduce
after reduction, shifting from state 118 to state 52
loop
state 52, reducing 1 by rule 72 (expression : expression_t)
reduce
after reduction, shifting from state 118 to state 147
loop
yyn:0  state:147  yychar:267
state 147, shifting to state 167
loop
yyn:0  state:167  yychar:-1
 next yychar:304
state 167, shifting to state 119
loop
state 119, reducing 1 by rule 67 (statement : NEWLINE)
reduce
after reduction, shifting from state 167 to state 124
loop
state 124, reducing 1 by rule 68 (statements : statement)
reduce
after reduction, shifting from state 167 to state 177
loop
yyn:0  state:177  yychar:-1
 next yychar:308
state 177, shifting to state 32
loop
yyn:0  state:32  yychar:-1
 next yychar:292
reduce
state 32, reducing 1 by rule 28 (compound_identifier : IDENTIFIER)
reduce
after reduction, shifting from state 177 to state 122
loop
yyn:0  state:122  yychar:292
state 122, shifting to state 150
loop
yyn:0  state:150  yychar:-1
 next yychar:308
state 150, shifting to state 32
loop
yyn:0  state:32  yychar:-1
 next yychar:280
reduce
state 32, reducing 1 by rule 28 (compound_identifier : IDENTIFIER)
reduce
after reduction, shifting from state 150 to state 41
loop
yyn:0  state:41  yychar:280
reduce
state 41, reducing 1 by rule 25 (identifier : compound_identifier)
reduce
after reduction, shifting from state 150 to state 40
loop
state 40, reducing 1 by rule 23 (primary_expression : identifier)
reduce
after reduction, shifting from state 150 to state 39
loop
state 39, reducing 1 by rule 29 (postfix_expression : primary_expression)
reduce
after reduction, shifting from state 150 to state 42
loop
yyn:0  state:42  yychar:280
reduce
state 42, reducing 1 by rule 37 (unary_expression : postfix_expression)
reduce
after reduction, shifting from state 150 to state 44
loop
state 44, reducing 1 by rule 47 (pow_expression : unary_expression)
reduce
after reduction, shifting from state 150 to state 47
loop
yyn:0  state:47  yychar:280
reduce
state 47, reducing 1 by rule 46 (multiplicative_expression : pow_expression)
reduce
after reduction, shifting from state 150 to state 46
loop
yyn:0  state:46  yychar:280
reduce
state 46, reducing 1 by rule 40 (additive_expression : multiplicative_expression)
reduce
after reduction, shifting from state 150 to state 45
loop
yyn:0  state:45  yychar:280
state 45, shifting to state 69
loop
yyn:0  state:69  yychar:-1
 next yychar:311
state 69, shifting to state 35
loop
state 35, reducing 1 by rule 11 (atom : NUMERIC)
reduce
after reduction, shifting from state 69 to state 37
loop
state 37, reducing 1 by rule 21 (primary_expression : atom)
reduce
after reduction, shifting from state 69 to state 39
loop
state 39, reducing 1 by rule 29 (postfix_expression : primary_expression)
reduce
after reduction, shifting from state 69 to state 42
loop
yyn:0  state:42  yychar:-1
 next yychar:304
reduce
state 42, reducing 1 by rule 37 (unary_expression : postfix_expression)
reduce
after reduction, shifting from state 69 to state 44
loop
state 44, reducing 1 by rule 47 (pow_expression : unary_expression)
reduce
after reduction, shifting from state 69 to state 47
loop
yyn:0  state:47  yychar:304
reduce
state 47, reducing 1 by rule 46 (multiplicative_expression : pow_expression)
reduce
after reduction, shifting from state 69 to state 102
loop
yyn:0  state:102  yychar:304
reduce
state 102, reducing 3 by rule 42 (additive_expression : additive_expression MINUS multiplicative_expression)
reduce
after reduction, shifting from state 150 to state 45
loop
yyn:0  state:45  yychar:304
reduce
state 45, reducing 1 by rule 49 (relational_expression : additive_expression)
reduce
after reduction, shifting from state 150 to state 48
loop
yyn:0  state:48  yychar:304
reduce
state 48, reducing 1 by rule 54 (equality_expression : relational_expression)
reduce
after reduction, shifting from state 150 to state 49
loop
yyn:0  state:49  yychar:304
reduce
state 49, reducing 1 by rule 57 (logical_and_expression : equality_expression)
reduce
after reduction, shifting from state 150 to state 50
loop
yyn:0  state:50  yychar:304
reduce
state 50, reducing 1 by rule 59 (logical_or_expression : logical_and_expression)
reduce
after reduction, shifting from state 150 to state 51
loop
yyn:0  state:51  yychar:304
reduce
state 51, reducing 1 by rule 74 (expression_t : logical_or_expression)
reduce
after reduction, shifting from state 150 to state 52
loop
state 52, reducing 1 by rule 72 (expression : expression_t)
reduce
after reduction, shifting from state 150 to state 169
loop
state 169, reducing 3 by rule 61 (assignment_expression : compound_identifier EQUALS expression)
reduce
after reduction, shifting from state 177 to state 123
loop
state 123, reducing 1 by rule 70 (assignment_statement : assignment_expression)
reduce
after reduction, shifting from state 177 to state 128
loop
yyn:0  state:128  yychar:304
state 128, shifting to state 154
loop
state 154, reducing 2 by rule 66 (statement : assignment_statement NEWLINE)
reduce
after reduction, shifting from state 177 to state 156
loop
state 156, reducing 2 by rule 69 (statements : statements statement)
reduce
after reduction, shifting from state 167 to state 177
loop
yyn:0  state:177  yychar:-1
 next yychar:304
state 177, shifting to state 119
loop
state 119, reducing 1 by rule 67 (statement : NEWLINE)
reduce
after reduction, shifting from state 177 to state 156
loop
state 156, reducing 2 by rule 69 (statements : statements statement)
reduce
after reduction, shifting from state 167 to state 177
loop
yyn:0  state:177  yychar:-1
 next yychar:269
state 177, shifting to state 185
loop
yyn:0  state:185  yychar:-1
 next yychar:296
state 185, shifting to state 31
loop
yyn:0  state:31  yychar:-1
 next yychar:296
state 31, shifting to state 31
loop
yyn:0  state:31  yychar:-1
 next yychar:308
state 31, shifting to state 32
loop
yyn:0  state:32  yychar:-1
 next yychar:300
reduce
state 32, reducing 1 by rule 28 (compound_identifier : IDENTIFIER)
reduce
after reduction, shifting from state 31 to state 41
loop
yyn:0  state:41  yychar:300
state 41, shifting to state 65
loop
yyn:0  state:65  yychar:-1
 next yychar:308
state 65, shifting to state 100
loop
state 100, reducing 3 by rule 27 (compound_identifier : compound_identifier DOT IDENTIFIER)
reduce
after reduction, shifting from state 31 to state 41
loop
yyn:0  state:41  yychar:-1
 next yychar:280
reduce
state 41, reducing 1 by rule 25 (identifier : compound_identifier)
reduce
after reduction, shifting from state 31 to state 40
loop
state 40, reducing 1 by rule 23 (primary_expression : identifier)
reduce
after reduction, shifting from state 31 to state 39
loop
state 39, reducing 1 by rule 29 (postfix_expression : primary_expression)
reduce
after reduction, shifting from state 31 to state 42
loop
yyn:0  state:42  yychar:280
reduce
state 42, reducing 1 by rule 37 (unary_expression : postfix_expression)
reduce
after reduction, shifting from state 31 to state 44
loop
state 44, reducing 1 by rule 47 (pow_expression : unary_expression)
reduce
after reduction, shifting from state 31 to state 47
loop
yyn:0  state:47  yychar:280
reduce
state 47, reducing 1 by rule 46 (multiplicative_expression : pow_expression)
reduce
after reduction, shifting from state 31 to state 46
loop
yyn:0  state:46  yychar:280
reduce
state 46, reducing 1 by rule 40 (additive_expression : multiplicative_expression)
reduce
after reduction, shifting from state 31 to state 45
loop
yyn:0  state:45  yychar:280
state 45, shifting to state 69
loop
yyn:0  state:69  yychar:-1
 next yychar:308
state 69, shifting to state 32
loop
yyn:0  state:32  yychar:-1
 next yychar:300
reduce
state 32, reducing 1 by rule 28 (compound_identifier : IDENTIFIER)
reduce
after reduction, shifting from state 69 to state 41
loop
yyn:0  state:41  yychar:300
state 41, shifting to state 65
loop
yyn:0  state:65  yychar:-1
 next yychar:308
state 65, shifting to state 100
loop
state 100, reducing 3 by rule 27 (compound_identifier : compound_identifier DOT IDENTIFIER)
reduce
after reduction, shifting from state 69 to state 41
loop
yyn:0  state:41  yychar:-1
 next yychar:297
reduce
state 41, reducing 1 by rule 25 (identifier : compound_identifier)
reduce
after reduction, shifting from state 69 to state 40
loop
state 40, reducing 1 by rule 23 (primary_expression : identifier)
reduce
after reduction, shifting from state 69 to state 39
loop
state 39, reducing 1 by rule 29 (postfix_expression : primary_expression)
reduce
after reduction, shifting from state 69 to state 42
loop
yyn:0  state:42  yychar:297
reduce
state 42, reducing 1 by rule 37 (unary_expression : postfix_expression)
reduce
after reduction, shifting from state 69 to state 44
loop
state 44, reducing 1 by rule 47 (pow_expression : unary_expression)
reduce
after reduction, shifting from state 69 to state 47
loop
yyn:0  state:47  yychar:297
reduce
state 47, reducing 1 by rule 46 (multiplicative_expression : pow_expression)
reduce
after reduction, shifting from state 69 to state 102
loop
yyn:0  state:102  yychar:297
reduce
state 102, reducing 3 by rule 42 (additive_expression : additive_expression MINUS multiplicative_expression)
reduce
after reduction, shifting from state 31 to state 45
loop
yyn:0  state:45  yychar:297
reduce
state 45, reducing 1 by rule 49 (relational_expression : additive_expression)
reduce
after reduction, shifting from state 31 to state 48
loop
yyn:0  state:48  yychar:297
reduce
state 48, reducing 1 by rule 54 (equality_expression : relational_expression)
reduce
after reduction, shifting from state 31 to state 49
loop
yyn:0  state:49  yychar:297
reduce
state 49, reducing 1 by rule 57 (logical_and_expression : equality_expression)
reduce
after reduction, shifting from state 31 to state 50
loop
yyn:0  state:50  yychar:297
reduce
state 50, reducing 1 by rule 59 (logical_or_expression : logical_and_expression)
reduce
after reduction, shifting from state 31 to state 51
loop
yyn:0  state:51  yychar:297
reduce
state 51, reducing 1 by rule 74 (expression_t : logical_or_expression)
reduce
after reduction, shifting from state 31 to state 52
loop
state 52, reducing 1 by rule 72 (expression : expression_t)
reduce
after reduction, shifting from state 31 to state 61
loop
yyn:0  state:61  yychar:297
state 61, shifting to state 95
loop
state 95, reducing 3 by rule 24 (primary_expression : LPAREN expression RPAREN)
reduce
after reduction, shifting from state 31 to state 39
loop
state 39, reducing 1 by rule 29 (postfix_expression : primary_expression)
reduce
after reduction, shifting from state 31 to state 42
loop
yyn:0  state:42  yychar:-1
 next yychar:282
reduce
state 42, reducing 1 by rule 37 (unary_expression : postfix_expression)
reduce
after reduction, shifting from state 31 to state 44
loop
state 44, reducing 1 by rule 47 (pow_expression : unary_expression)
reduce
after reduction, shifting from state 31 to state 47
loop
yyn:0  state:47  yychar:282
reduce
state 47, reducing 1 by rule 46 (multiplicative_expression : pow_expression)
reduce
after reduction, shifting from state 31 to state 46
loop
yyn:0  state:46  yychar:282
state 46, shifting to state 71
loop
yyn:0  state:71  yychar:-1
 next yychar:296
state 71, shifting to state 58
loop
yyn:0  state:58  yychar:-1
 next yychar:308
state 58, shifting to state 32
loop
yyn:0  state:32  yychar:-1
 next yychar:280
reduce
state 32, reducing 1 by rule 28 (compound_identifier : IDENTIFIER)
reduce
after reduction, shifting from state 58 to state 41
loop
yyn:0  state:41  yychar:280
reduce
state 41, reducing 1 by rule 25 (identifier : compound_identifier)
reduce
after reduction, shifting from state 58 to state 40
loop
state 40, reducing 1 by rule 23 (primary_expression : identifier)
reduce
after reduction, shifting from state 58 to state 39
loop
state 39, reducing 1 by rule 29 (postfix_expression : primary_expression)
reduce
after reduction, shifting from state 58 to state 42
loop
yyn:0  state:42  yychar:280
reduce
state 42, reducing 1 by rule 37 (unary_expression : postfix_expression)
reduce
after reduction, shifting from state 58 to state 44
loop
state 44, reducing 1 by rule 47 (pow_expression : unary_expression)
reduce
after reduction, shifting from state 58 to state 47
loop
yyn:0  state:47  yychar:280
reduce
state 47, reducing 1 by rule 46 (multiplicative_expression : pow_expression)
reduce
after reduction, shifting from state 58 to state 46
loop
yyn:0  state:46  yychar:280
reduce
state 46, reducing 1 by rule 40 (additive_expression : multiplicative_expression)
reduce
after reduction, shifting from state 58 to state 45
loop
yyn:0  state:45  yychar:280
state 45, shifting to state 69
loop
yyn:0  state:69  yychar:-1
 next yychar:308
state 69, shifting to state 32
loop
yyn:0  state:32  yychar:-1
 next yychar:297
reduce
state 32, reducing 1 by rule 28 (compound_identifier : IDENTIFIER)
reduce
after reduction, shifting from state 69 to state 41
loop
yyn:0  state:41  yychar:297
reduce
state 41, reducing 1 by rule 25 (identifier : compound_identifier)
reduce
after reduction, shifting from state 69 to state 40
loop
state 40, reducing 1 by rule 23 (primary_expression : identifier)
reduce
after reduction, shifting from state 69 to state 39
loop
state 39, reducing 1 by rule 29 (postfix_expression : primary_expression)
reduce
after reduction, shifting from state 69 to state 42
loop
yyn:0  state:42  yychar:297
reduce
state 42, reducing 1 by rule 37 (unary_expression : postfix_expression)
reduce
after reduction, shifting from state 69 to state 44
loop
state 44, reducing 1 by rule 47 (pow_expression : unary_expression)
reduce
after reduction, shifting from state 69 to state 47
loop
yyn:0  state:47  yychar:297
reduce
state 47, reducing 1 by rule 46 (multiplicative_expression : pow_expression)
reduce
after reduction, shifting from state 69 to state 102
loop
yyn:0  state:102  yychar:297
reduce
state 102, reducing 3 by rule 42 (additive_expression : additive_expression MINUS multiplicative_expression)
reduce
after reduction, shifting from state 58 to state 45
loop
yyn:0  state:45  yychar:297
reduce
state 45, reducing 1 by rule 49 (relational_expression : additive_expression)
reduce
after reduction, shifting from state 58 to state 48
loop
yyn:0  state:48  yychar:297
reduce
state 48, reducing 1 by rule 54 (equality_expression : relational_expression)
reduce
after reduction, shifting from state 58 to state 49
loop
yyn:0  state:49  yychar:297
reduce
state 49, reducing 1 by rule 57 (logical_and_expression : equality_expression)
reduce
after reduction, shifting from state 58 to state 50
loop
yyn:0  state:50  yychar:297
reduce
state 50, reducing 1 by rule 59 (logical_or_expression : logical_and_expression)
reduce
after reduction, shifting from state 58 to state 51
loop
yyn:0  state:51  yychar:297
reduce
state 51, reducing 1 by rule 74 (expression_t : logical_or_expression)
reduce
after reduction, shifting from state 58 to state 52
loop
state 52, reducing 1 by rule 72 (expression : expression_t)
reduce
after reduction, shifting from state 58 to state 94
loop
yyn:0  state:94  yychar:297
state 94, shifting to state 139
loop
state 139, reducing 3 by rule 24 (primary_expression : LPAREN expression RPAREN)
reduce
after reduction, shifting from state 71 to state 39
loop
state 39, reducing 1 by rule 29 (postfix_expression : primary_expression)
reduce
after reduction, shifting from state 71 to state 42
loop
yyn:0  state:42  yychar:-1
 next yychar:297
reduce
state 42, reducing 1 by rule 37 (unary_expression : postfix_expression)
reduce
after reduction, shifting from state 71 to state 44
loop
state 44, reducing 1 by rule 47 (pow_expression : unary_expression)
reduce
after reduction, shifting from state 71 to state 104
loop
yyn:0  state:104  yychar:297
reduce
state 104, reducing 3 by rule 44 (multiplicative_expression : multiplicative_expression DIV pow_expression)
reduce
after reduction, shifting from state 31 to state 46
loop
yyn:0  state:46  yychar:297
reduce
state 46, reducing 1 by rule 40 (additive_expression : multiplicative_expression)
reduce
after reduction, shifting from state 31 to state 45
loop
yyn:0  state:45  yychar:297
reduce
state 45, reducing 1 by rule 49 (relational_expression : additive_expression)
reduce
after reduction, shifting from state 31 to state 48
loop
yyn:0  state:48  yychar:297
reduce
state 48, reducing 1 by rule 54 (equality_expression : relational_expression)
reduce
after reduction, shifting from state 31 to state 49
loop
yyn:0  state:49  yychar:297
reduce
state 49, reducing 1 by rule 57 (logical_and_expression : equality_expression)
reduce
after reduction, shifting from state 31 to state 50
loop
yyn:0  state:50  yychar:297
reduce
state 50, reducing 1 by rule 59 (logical_or_expression : logical_and_expression)
reduce
after reduction, shifting from state 31 to state 51
loop
yyn:0  state:51  yychar:297
reduce
state 51, reducing 1 by rule 74 (expression_t : logical_or_expression)
reduce
after reduction, shifting from state 31 to state 52
loop
state 52, reducing 1 by rule 72 (expression : expression_t)
reduce
after reduction, shifting from state 31 to state 61
loop
yyn:0  state:61  yychar:297
state 61, shifting to state 95
loop
state 95, reducing 3 by rule 24 (primary_expression : LPAREN expression RPAREN)
reduce
after reduction, shifting from state 185 to state 39
loop
state 39, reducing 1 by rule 29 (postfix_expression : primary_expression)
reduce
after reduction, shifting from state 185 to state 42
loop
yyn:0  state:42  yychar:-1
 next yychar:292
reduce
state 42, reducing 1 by rule 37 (unary_expression : postfix_expression)
reduce
after reduction, shifting from state 185 to state 44
loop
state 44, reducing 1 by rule 47 (pow_expression : unary_expression)
reduce
after reduction, shifting from state 185 to state 47
loop
yyn:0  state:47  yychar:292
reduce
state 47, reducing 1 by rule 46 (multiplicative_expression : pow_expression)
reduce
after reduction, shifting from state 185 to state 46
loop
yyn:0  state:46  yychar:292
reduce
state 46, reducing 1 by rule 40 (additive_expression : multiplicative_expression)
reduce
after reduction, shifting from state 185 to state 45
loop
yyn:0  state:45  yychar:292
reduce
state 45, reducing 1 by rule 49 (relational_expression : additive_expression)
reduce
after reduction, shifting from state 185 to state 48
loop
yyn:0  state:48  yychar:292
reduce
state 48, reducing 1 by rule 54 (equality_expression : relational_expression)
reduce
after reduction, shifting from state 185 to state 49
loop
yyn:0  state:49  yychar:292
state 49, shifting to state 79
loop
yyn:0  state:79  yychar:-1
 next yychar:311
state 79, shifting to state 35
loop
state 35, reducing 1 by rule 11 (atom : NUMERIC)
reduce
after reduction, shifting from state 79 to state 37
loop
state 37, reducing 1 by rule 21 (primary_expression : atom)
reduce
after reduction, shifting from state 79 to state 39
loop
state 39, reducing 1 by rule 29 (postfix_expression : primary_expression)
reduce
after reduction, shifting from state 79 to state 42
loop
yyn:0  state:42  yychar:-1
 next yychar:267
reduce
state 42, reducing 1 by rule 37 (unary_expression : postfix_expression)
reduce
after reduction, shifting from state 79 to state 44
loop
state 44, reducing 1 by rule 47 (pow_expression : unary_expression)
reduce
after reduction, shifting from state 79 to state 47
loop
yyn:0  state:47  yychar:267
reduce
state 47, reducing 1 by rule 46 (multiplicative_expression : pow_expression)
reduce
after reduction, shifting from state 79 to state 46
loop
yyn:0  state:46  yychar:267
reduce
state 46, reducing 1 by rule 40 (additive_expression : multiplicative_expression)
reduce
after reduction, shifting from state 79 to state 45
loop
yyn:0  state:45  yychar:267
reduce
state 45, reducing 1 by rule 49 (relational_expression : additive_expression)
reduce
after reduction, shifting from state 79 to state 112
loop
yyn:0  state:112  yychar:267
reduce
state 112, reducing 3 by rule 55 (equality_expression : equality_expression EQUALS relational_expression)
reduce
after reduction, shifting from state 185 to state 49
loop
yyn:0  state:49  yychar:267
reduce
state 49, reducing 1 by rule 57 (logical_and_expression : equality_expression)
reduce
after reduction, shifting from state 185 to state 50
loop
yyn:0  state:50  yychar:267
reduce
state 50, reducing 1 by rule 59 (logical_or_expression : logical_and_expression)
reduce
after reduction, shifting from state 185 to state 51
loop
yyn:0  state:51  yychar:267
reduce
state 51, reducing 1 by rule 74 (expression_t : logical_or_expression)
reduce
after reduction, shifting from state 185 to state 52
loop
state 52, reducing 1 by rule 72 (expression : expression_t)
reduce
after reduction, shifting from state 185 to state 147
loop
yyn:0  state:147  yychar:267
state 147, shifting to state 167
loop
yyn:0  state:167  yychar:-1
 next yychar:304
state 167, shifting to state 119
loop
state 119, reducing 1 by rule 67 (statement : NEWLINE)
reduce
after reduction, shifting from state 167 to state 124
loop
state 124, reducing 1 by rule 68 (statements : statement)
reduce
after reduction, shifting from state 167 to state 177
loop
yyn:0  state:177  yychar:-1
 next yychar:308
state 177, shifting to state 32
loop
yyn:0  state:32  yychar:-1
 next yychar:292
reduce
state 32, reducing 1 by rule 28 (compound_identifier : IDENTIFIER)
reduce
after reduction, shifting from state 177 to state 122
loop
yyn:0  state:122  yychar:292
state 122, shifting to state 150
loop
yyn:0  state:150  yychar:-1
 next yychar:308
state 150, shifting to state 32
loop
yyn:0  state:32  yychar:-1
 next yychar:280
reduce
state 32, reducing 1 by rule 28 (compound_identifier : IDENTIFIER)
reduce
after reduction, shifting from state 150 to state 41
loop
yyn:0  state:41  yychar:280
reduce
state 41, reducing 1 by rule 25 (identifier : compound_identifier)
reduce
after reduction, shifting from state 150 to state 40
loop
state 40, reducing 1 by rule 23 (primary_expression : identifier)
reduce
after reduction, shifting from state 150 to state 39
loop
state 39, reducing 1 by rule 29 (postfix_expression : primary_expression)
reduce
after reduction, shifting from state 150 to state 42
loop
yyn:0  state:42  yychar:280
reduce
state 42, reducing 1 by rule 37 (unary_expression : postfix_expression)
reduce
after reduction, shifting from state 150 to state 44
loop
state 44, reducing 1 by rule 47 (pow_expression : unary_expression)
reduce
after reduction, shifting from state 150 to state 47
loop
yyn:0  state:47  yychar:280
reduce
state 47, reducing 1 by rule 46 (multiplicative_expression : pow_expression)
reduce
after reduction, shifting from state 150 to state 46
loop
yyn:0  state:46  yychar:280
reduce
state 46, reducing 1 by rule 40 (additive_expression : multiplicative_expression)
reduce
after reduction, shifting from state 150 to state 45
loop
yyn:0  state:45  yychar:280
state 45, shifting to state 69
loop
yyn:0  state:69  yychar:-1
 next yychar:311
state 69, shifting to state 35
loop
state 35, reducing 1 by rule 11 (atom : NUMERIC)
reduce
after reduction, shifting from state 69 to state 37
loop
state 37, reducing 1 by rule 21 (primary_expression : atom)
reduce
after reduction, shifting from state 69 to state 39
loop
state 39, reducing 1 by rule 29 (postfix_expression : primary_expression)
reduce
after reduction, shifting from state 69 to state 42
loop
yyn:0  state:42  yychar:-1
 next yychar:304
reduce
state 42, reducing 1 by rule 37 (unary_expression : postfix_expression)
reduce
after reduction, shifting from state 69 to state 44
loop
state 44, reducing 1 by rule 47 (pow_expression : unary_expression)
reduce
after reduction, shifting from state 69 to state 47
loop
yyn:0  state:47  yychar:304
reduce
state 47, reducing 1 by rule 46 (multiplicative_expression : pow_expression)
reduce
after reduction, shifting from state 69 to state 102
loop
yyn:0  state:102  yychar:304
reduce
state 102, reducing 3 by rule 42 (additive_expression : additive_expression MINUS multiplicative_expression)
reduce
after reduction, shifting from state 150 to state 45
loop
yyn:0  state:45  yychar:304
reduce
state 45, reducing 1 by rule 49 (relational_expression : additive_expression)
reduce
after reduction, shifting from state 150 to state 48
loop
yyn:0  state:48  yychar:304
reduce
state 48, reducing 1 by rule 54 (equality_expression : relational_expression)
reduce
after reduction, shifting from state 150 to state 49
loop
yyn:0  state:49  yychar:304
reduce
state 49, reducing 1 by rule 57 (logical_and_expression : equality_expression)
reduce
after reduction, shifting from state 150 to state 50
loop
yyn:0  state:50  yychar:304
reduce
state 50, reducing 1 by rule 59 (logical_or_expression : logical_and_expression)
reduce
after reduction, shifting from state 150 to state 51
loop
yyn:0  state:51  yychar:304
reduce
state 51, reducing 1 by rule 74 (expression_t : logical_or_expression)
reduce
after reduction, shifting from state 150 to state 52
loop
state 52, reducing 1 by rule 72 (expression : expression_t)
reduce
after reduction, shifting from state 150 to state 169
loop
state 169, reducing 3 by rule 61 (assignment_expression : compound_identifier EQUALS expression)
reduce
after reduction, shifting from state 177 to state 123
loop
state 123, reducing 1 by rule 70 (assignment_statement : assignment_expression)
reduce
after reduction, shifting from state 177 to state 128
loop
yyn:0  state:128  yychar:304
state 128, shifting to state 154
loop
state 154, reducing 2 by rule 66 (statement : assignment_statement NEWLINE)
reduce
after reduction, shifting from state 177 to state 156
loop
state 156, reducing 2 by rule 69 (statements : statements statement)
reduce
after reduction, shifting from state 167 to state 177
loop
yyn:0  state:177  yychar:-1
 next yychar:263
reduce
state 177, reducing 3 by rule 76 (partial_selection_statement : expression THEN statements)
reduce
after reduction, shifting from state 185 to state 190
loop
state 190, reducing 5 by rule 78 (partial_selection_statement : expression THEN statements ELSIF partial_selection_statement)
reduce
after reduction, shifting from state 118 to state 148
loop
yyn:0  state:148  yychar:263
state 148, shifting to state 168
loop
state 168, reducing 3 by rule 75 (selection_statement : IF partial_selection_statement END)
reduce
after reduction, shifting from state 199 to state 126
loop
yyn:0  state:126  yychar:-1
 next yychar:304
state 126, shifting to state 152
loop
state 152, reducing 2 by rule 63 (statement : selection_statement NEWLINE)
reduce
after reduction, shifting from state 199 to state 156
loop
state 156, reducing 2 by rule 69 (statements : statements statement)
reduce
after reduction, shifting from state 196 to state 199
loop
yyn:0  state:199  yychar:-1
 next yychar:263
state 199, shifting to state 200
loop
state 200, reducing 10 by rule 80 (iteration_statement : FOR identifier FROM expression TO expression by_statement NEWLINE statements END)
reduce
after reduction, shifting from state 199 to state 127
loop
yyn:0  state:127  yychar:-1
 next yychar:304
state 127, shifting to state 153
loop
state 153, reducing 2 by rule 64 (statement : iteration_statement NEWLINE)
reduce
after reduction, shifting from state 199 to state 156
loop
state 156, reducing 2 by rule 69 (statements : statements statement)
reduce
after reduction, shifting from state 196 to state 199
loop
yyn:0  state:199  yychar:-1
 next yychar:263
state 199, shifting to state 200
loop
state 200, reducing 10 by rule 80 (iteration_statement : FOR identifier FROM expression TO expression by_statement NEWLINE statements END)
reduce
after reduction, shifting from state 130 to state 127
loop
yyn:0  state:127  yychar:-1
 next yychar:304
state 127, shifting to state 153
loop
state 153, reducing 2 by rule 64 (statement : iteration_statement NEWLINE)
reduce
after reduction, shifting from state 130 to state 156
loop
state 156, reducing 2 by rule 69 (statements : statements statement)
reduce
after reduction, shifting from state 84 to state 130
loop
yyn:0  state:130  yychar:-1
 next yychar:304
state 130, shifting to state 119
loop
state 119, reducing 1 by rule 67 (statement : NEWLINE)
reduce
after reduction, shifting from state 130 to state 156
loop
state 156, reducing 2 by rule 69 (statements : statements statement)
reduce
after reduction, shifting from state 84 to state 130
loop
yyn:0  state:130  yychar:-1
 next yychar:261
state 130, shifting to state 157
loop
yyn:0  state:157  yychar:-1
 next yychar:311
state 157, shifting to state 35
loop
state 35, reducing 1 by rule 11 (atom : NUMERIC)
reduce
after reduction, shifting from state 157 to state 37
loop
state 37, reducing 1 by rule 21 (primary_expression : atom)
reduce
after reduction, shifting from state 157 to state 39
loop
state 39, reducing 1 by rule 29 (postfix_expression : primary_expression)
reduce
after reduction, shifting from state 157 to state 42
loop
yyn:0  state:42  yychar:-1
 next yychar:280
reduce
state 42, reducing 1 by rule 37 (unary_expression : postfix_expression)
reduce
after reduction, shifting from state 157 to state 44
loop
state 44, reducing 1 by rule 47 (pow_expression : unary_expression)
reduce
after reduction, shifting from state 157 to state 47
loop
yyn:0  state:47  yychar:280
reduce
state 47, reducing 1 by rule 46 (multiplicative_expression : pow_expression)
reduce
after reduction, shifting from state 157 to state 46
loop
yyn:0  state:46  yychar:280
reduce
state 46, reducing 1 by rule 40 (additive_expression : multiplicative_expression)
reduce
after reduction, shifting from state 157 to state 45
loop
yyn:0  state:45  yychar:280
state 45, shifting to state 69
loop
yyn:0  state:69  yychar:-1
 next yychar:308
state 69, shifting to state 32
loop
yyn:0  state:32  yychar:-1
 next yychar:304
reduce
state 32, reducing 1 by rule 28 (compound_identifier : IDENTIFIER)
reduce
after reduction, shifting from state 69 to state 41
loop
yyn:0  state:41  yychar:304
reduce
state 41, reducing 1 by rule 25 (identifier : compound_identifier)
reduce
after reduction, shifting from state 69 to state 40
loop
state 40, reducing 1 by rule 23 (primary_expression : identifier)
reduce
after reduction, shifting from state 69 to state 39
loop
state 39, reducing 1 by rule 29 (postfix_expression : primary_expression)
reduce
after reduction, shifting from state 69 to state 42
loop
yyn:0  state:42  yychar:304
reduce
state 42, reducing 1 by rule 37 (unary_expression : postfix_expression)
reduce
after reduction, shifting from state 69 to state 44
loop
state 44, reducing 1 by rule 47 (pow_expression : unary_expression)
reduce
after reduction, shifting from state 69 to state 47
loop
yyn:0  state:47  yychar:304
reduce
state 47, reducing 1 by rule 46 (multiplicative_expression : pow_expression)
reduce
after reduction, shifting from state 69 to state 102
loop
yyn:0  state:102  yychar:304
reduce
state 102, reducing 3 by rule 42 (additive_expression : additive_expression MINUS multiplicative_expression)
reduce
after reduction, shifting from state 157 to state 45
loop
yyn:0  state:45  yychar:304
reduce
state 45, reducing 1 by rule 49 (relational_expression : additive_expression)
reduce
after reduction, shifting from state 157 to state 48
loop
yyn:0  state:48  yychar:304
reduce
state 48, reducing 1 by rule 54 (equality_expression : relational_expression)
reduce
after reduction, shifting from state 157 to state 49
loop
yyn:0  state:49  yychar:304
reduce
state 49, reducing 1 by rule 57 (logical_and_expression : equality_expression)
reduce
after reduction, shifting from state 157 to state 50
loop
yyn:0  state:50  yychar:304
reduce
state 50, reducing 1 by rule 59 (logical_or_expression : logical_and_expression)
reduce
after reduction, shifting from state 157 to state 51
loop
yyn:0  state:51  yychar:304
reduce
state 51, reducing 1 by rule 74 (expression_t : logical_or_expression)
reduce
after reduction, shifting from state 157 to state 52
loop
state 52, reducing 1 by rule 72 (expression : expression_t)
reduce
after reduction, shifting from state 157 to state 170
loop
yyn:0  state:170  yychar:304
state 170, shifting to state 178
loop
state 178, reducing 3 by rule 94 (opt_return : RETURN expression NEWLINE)
reduce
after reduction, shifting from state 130 to state 158
loop
yyn:0  state:158  yychar:-1
 next yychar:263
state 158, shifting to state 171
loop
state 171, reducing 8 by rule 93 (function_declarator : TO IDENTIFIER COLON params NEWLINE statements opt_return END)
reduce
after reduction, shifting from state 9 to state 11
loop
state 11, reducing 1 by rule 4 (external_declaration : function_declarator)
reduce
after reduction, shifting from state 9 to state 23
loop
state 23, reducing 2 by rule 3 (program_unit : program_unit external_declaration)
reduce
after reduction, shifting from state 0 to state 9
loop
yyn:0  state:9  yychar:-1
 next yychar:304
state 9, shifting to state 6
loop
state 6, reducing 1 by rule 9 (external_declaration : NEWLINE)
reduce
after reduction, shifting from state 9 to state 23
loop
state 23, reducing 2 by rule 3 (program_unit : program_unit external_declaration)
reduce
after reduction, shifting from state 0 to state 9
loop
yyn:0  state:9  yychar:-1
 next yychar:304
state 9, shifting to state 6
loop
state 6, reducing 1 by rule 9 (external_declaration : NEWLINE)
reduce
after reduction, shifting from state 9 to state 23
loop
state 23, reducing 2 by rule 3 (program_unit : program_unit external_declaration)
reduce
after reduction, shifting from state 0 to state 9
loop
yyn:0  state:9  yychar:-1
 next yychar:257
state 9, shifting to state 1
loop
yyn:0  state:1  yychar:-1
 next yychar:308
state 1, shifting to state 17
loop
yyn:0  state:17  yychar:-1
 next yychar:298
state 17, shifting to state 25
loop
state 25, reducing 0 by rule 35 (params :)
reduce
after reduction, shifting from state 25 to state 54
loop
yyn:0  state:54  yychar:-1
 next yychar:308
reduce
state 54, reducing 0 by rule 14 (commaq :)
reduce
after reduction, shifting from state 54 to state 85
loop
yyn:0  state:85  yychar:308
state 85, shifting to state 32
loop
yyn:0  state:32  yychar:-1
 next yychar:308
reduce
state 32, reducing 1 by rule 28 (compound_identifier : IDENTIFIER)
reduce
after reduction, shifting from state 85 to state 41
loop
yyn:0  state:41  yychar:308
reduce
state 41, reducing 1 by rule 25 (identifier : compound_identifier)
reduce
after reduction, shifting from state 85 to state 40
loop
state 40, reducing 1 by rule 23 (primary_expression : identifier)
reduce
after reduction, shifting from state 85 to state 39
loop
state 39, reducing 1 by rule 29 (postfix_expression : primary_expression)
reduce
after reduction, shifting from state 85 to state 42
loop
yyn:0  state:42  yychar:308
reduce
state 42, reducing 1 by rule 37 (unary_expression : postfix_expression)
reduce
after reduction, shifting from state 85 to state 44
loop
state 44, reducing 1 by rule 47 (pow_expression : unary_expression)
reduce
after reduction, shifting from state 85 to state 47
loop
yyn:0  state:47  yychar:308
reduce
state 47, reducing 1 by rule 46 (multiplicative_expression : pow_expression)
reduce
after reduction, shifting from state 85 to state 46
loop
yyn:0  state:46  yychar:308
reduce
state 46, reducing 1 by rule 40 (additive_expression : multiplicative_expression)
reduce
after reduction, shifting from state 85 to state 45
loop
yyn:0  state:45  yychar:308
reduce
state 45, reducing 1 by rule 49 (relational_expression : additive_expression)
reduce
after reduction, shifting from state 85 to state 48
loop
yyn:0  state:48  yychar:308
reduce
state 48, reducing 1 by rule 54 (equality_expression : relational_expression)
reduce
after reduction, shifting from state 85 to state 49
loop
yyn:0  state:49  yychar:308
reduce
state 49, reducing 1 by rule 57 (logical_and_expression : equality_expression)
reduce
after reduction, shifting from state 85 to state 50
loop
yyn:0  state:50  yychar:308
reduce
state 50, reducing 1 by rule 59 (logical_or_expression : logical_and_expression)
reduce
after reduction, shifting from state 85 to state 51
loop
yyn:0  state:51  yychar:308
reduce
state 51, reducing 1 by rule 74 (expression_t : logical_or_expression)
reduce
after reduction, shifting from state 85 to state 52
loop
state 52, reducing 1 by rule 72 (expression : expression_t)
reduce
after reduction, shifting from state 85 to state 131
loop
state 131, reducing 1 by rule 36 (param : expression)
reduce
after reduction, shifting from state 85 to state 132
loop
state 132, reducing 3 by rule 34 (params : params commaq param)
reduce
after reduction, shifting from state 25 to state 54
loop
yyn:0  state:54  yychar:308
reduce
state 54, reducing 0 by rule 14 (commaq :)
reduce
after reduction, shifting from state 54 to state 85
loop
yyn:0  state:85  yychar:308
state 85, shifting to state 32
loop
yyn:0  state:32  yychar:-1
 next yychar:308
reduce
state 32, reducing 1 by rule 28 (compound_identifier : IDENTIFIER)
reduce
after reduction, shifting from state 85 to state 41
loop
yyn:0  state:41  yychar:308
reduce
state 41, reducing 1 by rule 25 (identifier : compound_identifier)
reduce
after reduction, shifting from state 85 to state 40
loop
state 40, reducing 1 by rule 23 (primary_expression : identifier)
reduce
after reduction, shifting from state 85 to state 39
loop
state 39, reducing 1 by rule 29 (postfix_expression : primary_expression)
reduce
after reduction, shifting from state 85 to state 42
loop
yyn:0  state:42  yychar:308
reduce
state 42, reducing 1 by rule 37 (unary_expression : postfix_expression)
reduce
after reduction, shifting from state 85 to state 44
loop
state 44, reducing 1 by rule 47 (pow_expression : unary_expression)
reduce
after reduction, shifting from state 85 to state 47
loop
yyn:0  state:47  yychar:308
reduce
state 47, reducing 1 by rule 46 (multiplicative_expression : pow_expression)
reduce
after reduction, shifting from state 85 to state 46
loop
yyn:0  state:46  yychar:308
reduce
state 46, reducing 1 by rule 40 (additive_expression : multiplicative_expression)
reduce
after reduction, shifting from state 85 to state 45
loop
yyn:0  state:45  yychar:308
reduce
state 45, reducing 1 by rule 49 (relational_expression : additive_expression)
reduce
after reduction, shifting from state 85 to state 48
loop
yyn:0  state:48  yychar:308
reduce
state 48, reducing 1 by rule 54 (equality_expression : relational_expression)
reduce
after reduction, shifting from state 85 to state 49
loop
yyn:0  state:49  yychar:308
reduce
state 49, reducing 1 by rule 57 (logical_and_expression : equality_expression)
reduce
after reduction, shifting from state 85 to state 50
loop
yyn:0  state:50  yychar:308
reduce
state 50, reducing 1 by rule 59 (logical_or_expression : logical_and_expression)
reduce
after reduction, shifting from state 85 to state 51
loop
yyn:0  state:51  yychar:308
reduce
state 51, reducing 1 by rule 74 (expression_t : logical_or_expression)
reduce
after reduction, shifting from state 85 to state 52
loop
state 52, reducing 1 by rule 72 (expression : expression_t)
reduce
after reduction, shifting from state 85 to state 131
loop
state 131, reducing 1 by rule 36 (param : expression)
reduce
after reduction, shifting from state 85 to state 132
loop
state 132, reducing 3 by rule 34 (params : params commaq param)
reduce
after reduction, shifting from state 25 to state 54
loop
yyn:0  state:54  yychar:308
reduce
state 54, reducing 0 by rule 14 (commaq :)
reduce
after reduction, shifting from state 54 to state 85
loop
yyn:0  state:85  yychar:308
state 85, shifting to state 32
loop
yyn:0  state:32  yychar:-1
 next yychar:304
reduce
state 32, reducing 1 by rule 28 (compound_identifier : IDENTIFIER)
reduce
after reduction, shifting from state 85 to state 41
loop
yyn:0  state:41  yychar:304
reduce
state 41, reducing 1 by rule 25 (identifier : compound_identifier)
reduce
after reduction, shifting from state 85 to state 40
loop
state 40, reducing 1 by rule 23 (primary_expression : identifier)
reduce
after reduction, shifting from state 85 to state 39
loop
state 39, reducing 1 by rule 29 (postfix_expression : primary_expression)
reduce
after reduction, shifting from state 85 to state 42
loop
yyn:0  state:42  yychar:304
reduce
state 42, reducing 1 by rule 37 (unary_expression : postfix_expression)
reduce
after reduction, shifting from state 85 to state 44
loop
state 44, reducing 1 by rule 47 (pow_expression : unary_expression)
reduce
after reduction, shifting from state 85 to state 47
loop
yyn:0  state:47  yychar:304
reduce
state 47, reducing 1 by rule 46 (multiplicative_expression : pow_expression)
reduce
after reduction, shifting from state 85 to state 46
loop
yyn:0  state:46  yychar:304
reduce
state 46, reducing 1 by rule 40 (additive_expression : multiplicative_expression)
reduce
after reduction, shifting from state 85 to state 45
loop
yyn:0  state:45  yychar:304
reduce
state 45, reducing 1 by rule 49 (relational_expression : additive_expression)
reduce
after reduction, shifting from state 85 to state 48
loop
yyn:0  state:48  yychar:304
reduce
state 48, reducing 1 by rule 54 (equality_expression : relational_expression)
reduce
after reduction, shifting from state 85 to state 49
loop
yyn:0  state:49  yychar:304
reduce
state 49, reducing 1 by rule 57 (logical_and_expression : equality_expression)
reduce
after reduction, shifting from state 85 to state 50
loop
yyn:0  state:50  yychar:304
reduce
state 50, reducing 1 by rule 59 (logical_or_expression : logical_and_expression)
reduce
after reduction, shifting from state 85 to state 51
loop
yyn:0  state:51  yychar:304
reduce
state 51, reducing 1 by rule 74 (expression_t : logical_or_expression)
reduce
after reduction, shifting from state 85 to state 52
loop
state 52, reducing 1 by rule 72 (expression : expression_t)
reduce
after reduction, shifting from state 85 to state 131
loop
state 131, reducing 1 by rule 36 (param : expression)
reduce
after reduction, shifting from state 85 to state 132
loop
state 132, reducing 3 by rule 34 (params : params commaq param)
reduce
after reduction, shifting from state 25 to state 54
loop
yyn:0  state:54  yychar:304
state 54, shifting to state 84
loop
yyn:0  state:84  yychar:-1
 next yychar:304
state 84, shifting to state 119
loop
state 119, reducing 1 by rule 67 (statement : NEWLINE)
reduce
after reduction, shifting from state 84 to state 124
loop
state 124, reducing 1 by rule 68 (statements : statement)
reduce
after reduction, shifting from state 84 to state 130
loop
yyn:0  state:130  yychar:-1
 next yychar:308
state 130, shifting to state 32
loop
yyn:0  state:32  yychar:-1
 next yychar:300
reduce
state 32, reducing 1 by rule 28 (compound_identifier : IDENTIFIER)
reduce
after reduction, shifting from state 130 to state 122
loop
yyn:0  state:122  yychar:300
state 122, shifting to state 65
loop
yyn:0  state:65  yychar:-1
 next yychar:308
state 65, shifting to state 100
loop
state 100, reducing 3 by rule 27 (compound_identifier : compound_identifier DOT IDENTIFIER)
reduce
after reduction, shifting from state 130 to state 122
loop
yyn:0  state:122  yychar:-1
 next yychar:292
state 122, shifting to state 150
loop
yyn:0  state:150  yychar:-1
 next yychar:308
state 150, shifting to state 32
loop
yyn:0  state:32  yychar:-1
 next yychar:298
state 32, shifting to state 64
loop
state 64, reducing 0 by rule 35 (params :)
reduce
after reduction, shifting from state 64 to state 99
loop
yyn:0  state:99  yychar:-1
 next yychar:296
reduce
state 99, reducing 0 by rule 14 (commaq :)
reduce
after reduction, shifting from state 99 to state 85
loop
yyn:0  state:85  yychar:296
state 85, shifting to state 31
loop
yyn:0  state:31  yychar:-1
 next yychar:308
state 31, shifting to state 32
loop
yyn:0  state:32  yychar:-1
 next yychar:298
state 32, shifting to state 64
loop
state 64, reducing 0 by rule 35 (params :)
reduce
after reduction, shifting from state 64 to state 99
loop
yyn:0  state:99  yychar:-1
 next yychar:311
reduce
state 99, reducing 0 by rule 14 (commaq :)
reduce
after reduction, shifting from state 99 to state 85
loop
yyn:0  state:85  yychar:311
state 85, shifting to state 35
loop
state 35, reducing 1 by rule 11 (atom : NUMERIC)
reduce
after reduction, shifting from state 85 to state 37
loop
state 37, reducing 1 by rule 21 (primary_expression : atom)
reduce
after reduction, shifting from state 85 to state 39
loop
state 39, reducing 1 by rule 29 (postfix_expression : primary_expression)
reduce
after reduction, shifting from state 85 to state 42
loop
yyn:0  state:42  yychar:-1
 next yychar:311
reduce
state 42, reducing 1 by rule 37 (unary_expression : postfix_expression)
reduce
after reduction, shifting from state 85 to state 44
loop
state 44, reducing 1 by rule 47 (pow_expression : unary_expression)
reduce
after reduction, shifting from state 85 to state 47
loop
yyn:0  state:47  yychar:311
reduce
state 47, reducing 1 by rule 46 (multiplicative_expression : pow_expression)
reduce
after reduction, shifting from state 85 to state 46
loop
yyn:0  state:46  yychar:311
reduce
state 46, reducing 1 by rule 40 (additive_expression : multiplicative_expression)
reduce
after reduction, shifting from state 85 to state 45
loop
yyn:0  state:45  yychar:311
reduce
state 45, reducing 1 by rule 49 (relational_expression : additive_expression)
reduce
after reduction, shifting from state 85 to state 48
loop
yyn:0  state:48  yychar:311
reduce
state 48, reducing 1 by rule 54 (equality_expression : relational_expression)
reduce
after reduction, shifting from state 85 to state 49
loop
yyn:0  state:49  yychar:311
reduce
state 49, reducing 1 by rule 57 (logical_and_expression : equality_expression)
reduce
after reduction, shifting from state 85 to state 50
loop
yyn:0  state:50  yychar:311
reduce
state 50, reducing 1 by rule 59 (logical_or_expression : logical_and_expression)
reduce
after reduction, shifting from state 85 to state 51
loop
yyn:0  state:51  yychar:311
reduce
state 51, reducing 1 by rule 74 (expression_t : logical_or_expression)
reduce
after reduction, shifting from state 85 to state 52
loop
state 52, reducing 1 by rule 72 (expression : expression_t)
reduce
after reduction, shifting from state 85 to state 131
loop
state 131, reducing 1 by rule 36 (param : expression)
reduce
after reduction, shifting from state 85 to state 132
loop
state 132, reducing 3 by rule 34 (params : params commaq param)
reduce
after reduction, shifting from state 64 to state 99
loop
yyn:0  state:99  yychar:311
reduce
state 99, reducing 0 by rule 14 (commaq :)
reduce
after reduction, shifting from state 99 to state 85
loop
yyn:0  state:85  yychar:311
state 85, shifting to state 35
loop
state 35, reducing 1 by rule 11 (atom : NUMERIC)
reduce
after reduction, shifting from state 85 to state 37
loop
state 37, reducing 1 by rule 21 (primary_expression : atom)
reduce
after reduction, shifting from state 85 to state 39
loop
state 39, reducing 1 by rule 29 (postfix_expression : primary_expression)
reduce
after reduction, shifting from state 85 to state 42
loop
yyn:0  state:42  yychar:-1
 next yychar:297
reduce
state 42, reducing 1 by rule 37 (unary_expression : postfix_expression)
reduce
after reduction, shifting from state 85 to state 44
loop
state 44, reducing 1 by rule 47 (pow_expression : unary_expression)
reduce
after reduction, shifting from state 85 to state 47
loop
yyn:0  state:47  yychar:297
reduce
state 47, reducing 1 by rule 46 (multiplicative_expression : pow_expression)
reduce
after reduction, shifting from state 85 to state 46
loop
yyn:0  state:46  yychar:297
reduce
state 46, reducing 1 by rule 40 (additive_expression : multiplicative_expression)
reduce
after reduction, shifting from state 85 to state 45
loop
yyn:0  state:45  yychar:297
reduce
state 45, reducing 1 by rule 49 (relational_expression : additive_expression)
reduce
after reduction, shifting from state 85 to state 48
loop
yyn:0  state:48  yychar:297
reduce
state 48, reducing 1 by rule 54 (equality_expression : relational_expression)
reduce
after reduction, shifting from state 85 to state 49
loop
yyn:0  state:49  yychar:297
reduce
state 49, reducing 1 by rule 57 (logical_and_expression : equality_expression)
reduce
after reduction, shifting from state 85 to state 50
loop
yyn:0  state:50  yychar:297
reduce
state 50, reducing 1 by rule 59 (logical_or_expression : logical_and_expression)
reduce
after reduction, shifting from state 85 to state 51
loop
yyn:0  state:51  yychar:297
reduce
state 51, reducing 1 by rule 74 (expression_t : logical_or_expression)
reduce
after reduction, shifting from state 85 to state 52
loop
state 52, reducing 1 by rule 72 (expression : expression_t)
reduce
after reduction, shifting from state 85 to state 131
loop
state 131, reducing 1 by rule 36 (param : expression)
reduce
after reduction, shifting from state 85 to state 132
loop
state 132, reducing 3 by rule 34 (params : params commaq param)
reduce
after reduction, shifting from state 64 to state 99
loop
yyn:0  state:99  yychar:297
reduce
state 99, reducing 3 by rule 33 (function_expression : IDENTIFIER COLON params)
reduce
after reduction, shifting from state 31 to state 43
loop
state 43, reducing 1 by rule 32 (postfix_expression : function_expression)
reduce
after reduction, shifting from state 31 to state 42
loop
yyn:0  state:42  yychar:297
reduce
state 42, reducing 1 by rule 37 (unary_expression : postfix_expression)
reduce
after reduction, shifting from state 31 to state 44
loop
state 44, reducing 1 by rule 47 (pow_expression : unary_expression)
reduce
after reduction, shifting from state 31 to state 47
loop
yyn:0  state:47  yychar:297
reduce
state 47, reducing 1 by rule 46 (multiplicative_expression : pow_expression)
reduce
after reduction, shifting from state 31 to state 46
loop
yyn:0  state:46  yychar:297
reduce
state 46, reducing 1 by rule 40 (additive_expression : multiplicative_expression)
reduce
after reduction, shifting from state 31 to state 45
loop
yyn:0  state:45  yychar:297
reduce
state 45, reducing 1 by rule 49 (relational_expression : additive_expression)
reduce
after reduction, shifting from state 31 to state 48
loop
yyn:0  state:48  yychar:297
reduce
state 48, reducing 1 by rule 54 (equality_expression : relational_expression)
reduce
after reduction, shifting from state 31 to state 49
loop
yyn:0  state:49  yychar:297
reduce
state 49, reducing 1 by rule 57 (logical_and_expression : equality_expression)
reduce
after reduction, shifting from state 31 to state 50
loop
yyn:0  state:50  yychar:297
reduce
state 50, reducing 1 by rule 59 (logical_or_expression : logical_and_expression)
reduce
after reduction, shifting from state 31 to state 51
loop
yyn:0  state:51  yychar:297
reduce
state 51, reducing 1 by rule 74 (expression_t : logical_or_expression)
reduce
after reduction, shifting from state 31 to state 52
loop
state 52, reducing 1 by rule 72 (expression : expression_t)
reduce
after reduction, shifting from state 31 to state 61
loop
yyn:0  state:61  yychar:297
state 61, shifting to state 95
loop
state 95, reducing 3 by rule 24 (primary_expression : LPAREN expression RPAREN)
reduce
after reduction, shifting from state 85 to state 39
loop
state 39, reducing 1 by rule 29 (postfix_expression : primary_expression)
reduce
after reduction, shifting from state 85 to state 42
loop
yyn:0  state:42  yychar:-1
 next yychar:304
reduce
state 42, reducing 1 by rule 37 (unary_expression : postfix_expression)
reduce
after reduction, shifting from state 85 to state 44
loop
state 44, reducing 1 by rule 47 (pow_expression : unary_expression)
reduce
after reduction, shifting from state 85 to state 47
loop
yyn:0  state:47  yychar:304
reduce
state 47, reducing 1 by rule 46 (multiplicative_expression : pow_expression)
reduce
after reduction, shifting from state 85 to state 46
loop
yyn:0  state:46  yychar:304
reduce
state 46, reducing 1 by rule 40 (additive_expression : multiplicative_expression)
reduce
after reduction, shifting from state 85 to state 45
loop
yyn:0  state:45  yychar:304
reduce
state 45, reducing 1 by rule 49 (relational_expression : additive_expression)
reduce
after reduction, shifting from state 85 to state 48
loop
yyn:0  state:48  yychar:304
reduce
state 48, reducing 1 by rule 54 (equality_expression : relational_expression)
reduce
after reduction, shifting from state 85 to state 49
loop
yyn:0  state:49  yychar:304
reduce
state 49, reducing 1 by rule 57 (logical_and_expression : equality_expression)
reduce
after reduction, shifting from state 85 to state 50
loop
yyn:0  state:50  yychar:304
reduce
state 50, reducing 1 by rule 59 (logical_or_expression : logical_and_expression)
reduce
after reduction, shifting from state 85 to state 51
loop
yyn:0  state:51  yychar:304
reduce
state 51, reducing 1 by rule 74 (expression_t : logical_or_expression)
reduce
after reduction, shifting from state 85 to state 52
loop
state 52, reducing 1 by rule 72 (expression : expression_t)
reduce
after reduction, shifting from state 85 to state 131
loop
state 131, reducing 1 by rule 36 (param : expression)
reduce
after reduction, shifting from state 85 to state 132
loop
state 132, reducing 3 by rule 34 (params : params commaq param)
reduce
after reduction, shifting from state 64 to state 99
loop
yyn:0  state:99  yychar:304
reduce
state 99, reducing 3 by rule 33 (function_expression : IDENTIFIER COLON params)
reduce
after reduction, shifting from state 150 to state 43
loop
state 43, reducing 1 by rule 32 (postfix_expression : function_expression)
reduce
after reduction, shifting from state 150 to state 42
loop
yyn:0  state:42  yychar:304
reduce
state 42, reducing 1 by rule 37 (unary_expression : postfix_expression)
reduce
after reduction, shifting from state 150 to state 44
loop
state 44, reducing 1 by rule 47 (pow_expression : unary_expression)
reduce
after reduction, shifting from state 150 to state 47
loop
yyn:0  state:47  yychar:304
reduce
state 47, reducing 1 by rule 46 (multiplicative_expression : pow_expression)
reduce
after reduction, shifting from state 150 to state 46
loop
yyn:0  state:46  yychar:304
reduce
state 46, reducing 1 by rule 40 (additive_expression : multiplicative_expression)
reduce
after reduction, shifting from state 150 to state 45
loop
yyn:0  state:45  yychar:304
reduce
state 45, reducing 1 by rule 49 (relational_expression : additive_expression)
reduce
after reduction, shifting from state 150 to state 48
loop
yyn:0  state:48  yychar:304
reduce
state 48, reducing 1 by rule 54 (equality_expression : relational_expression)
reduce
after reduction, shifting from state 150 to state 49
loop
yyn:0  state:49  yychar:304
reduce
state 49, reducing 1 by rule 57 (logical_and_expression : equality_expression)
reduce
after reduction, shifting from state 150 to state 50
loop
yyn:0  state:50  yychar:304
reduce
state 50, reducing 1 by rule 59 (logical_or_expression : logical_and_expression)
reduce
after reduction, shifting from state 150 to state 51
loop
yyn:0  state:51  yychar:304
reduce
state 51, reducing 1 by rule 74 (expression_t : logical_or_expression)
reduce
after reduction, shifting from state 150 to state 52
loop
state 52, reducing 1 by rule 72 (expression : expression_t)
reduce
after reduction, shifting from state 150 to state 169
loop
state 169, reducing 3 by rule 61 (assignment_expression : compound_identifier EQUALS expression)
reduce
after reduction, shifting from state 130 to state 123
loop
state 123, reducing 1 by rule 70 (assignment_statement : assignment_expression)
reduce
after reduction, shifting from state 130 to state 128
loop
yyn:0  state:128  yychar:304
state 128, shifting to state 154
loop
state 154, reducing 2 by rule 66 (statement : assignment_statement NEWLINE)
reduce
after reduction, shifting from state 130 to state 156
loop
state 156, reducing 2 by rule 69 (statements : statements statement)
reduce
after reduction, shifting from state 84 to state 130
loop
yyn:0  state:130  yychar:-1
 next yychar:261
state 130, shifting to state 157
loop
yyn:0  state:157  yychar:-1
 next yychar:308
state 157, shifting to state 32
loop
yyn:0  state:32  yychar:-1
 next yychar:304
reduce
state 32, reducing 1 by rule 28 (compound_identifier : IDENTIFIER)
reduce
after reduction, shifting from state 157 to state 41
loop
yyn:0  state:41  yychar:304
reduce
state 41, reducing 1 by rule 25 (identifier : compound_identifier)
reduce
after reduction, shifting from state 157 to state 40
loop
state 40, reducing 1 by rule 23 (primary_expression : identifier)
reduce
after reduction, shifting from state 157 to state 39
loop
state 39, reducing 1 by rule 29 (postfix_expression : primary_expression)
reduce
after reduction, shifting from state 157 to state 42
loop
yyn:0  state:42  yychar:304
reduce
state 42, reducing 1 by rule 37 (unary_expression : postfix_expression)
reduce
after reduction, shifting from state 157 to state 44
loop
state 44, reducing 1 by rule 47 (pow_expression : unary_expression)
reduce
after reduction, shifting from state 157 to state 47
loop
yyn:0  state:47  yychar:304
reduce
state 47, reducing 1 by rule 46 (multiplicative_expression : pow_expression)
reduce
after reduction, shifting from state 157 to state 46
loop
yyn:0  state:46  yychar:304
reduce
state 46, reducing 1 by rule 40 (additive_expression : multiplicative_expression)
reduce
after reduction, shifting from state 157 to state 45
loop
yyn:0  state:45  yychar:304
reduce
state 45, reducing 1 by rule 49 (relational_expression : additive_expression)
reduce
after reduction, shifting from state 157 to state 48
loop
yyn:0  state:48  yychar:304
reduce
state 48, reducing 1 by rule 54 (equality_expression : relational_expression)
reduce
after reduction, shifting from state 157 to state 49
loop
yyn:0  state:49  yychar:304
reduce
state 49, reducing 1 by rule 57 (logical_and_expression : equality_expression)
reduce
after reduction, shifting from state 157 to state 50
loop
yyn:0  state:50  yychar:304
reduce
state 50, reducing 1 by rule 59 (logical_or_expression : logical_and_expression)
reduce
after reduction, shifting from state 157 to state 51
loop
yyn:0  state:51  yychar:304
reduce
state 51, reducing 1 by rule 74 (expression_t : logical_or_expression)
reduce
after reduction, shifting from state 157 to state 52
loop
state 52, reducing 1 by rule 72 (expression : expression_t)
reduce
after reduction, shifting from state 157 to state 170
loop
yyn:0  state:170  yychar:304
state 170, shifting to state 178
loop
state 178, reducing 3 by rule 94 (opt_return : RETURN expression NEWLINE)
reduce
after reduction, shifting from state 130 to state 158
loop
yyn:0  state:158  yychar:-1
 next yychar:263
state 158, shifting to state 171
loop
state 171, reducing 8 by rule 93 (function_declarator : TO IDENTIFIER COLON params NEWLINE statements opt_return END)
reduce
after reduction, shifting from state 9 to state 11
loop
state 11, reducing 1 by rule 4 (external_declaration : function_declarator)
reduce
after reduction, shifting from state 9 to state 23
loop
state 23, reducing 2 by rule 3 (program_unit : program_unit external_declaration)
reduce
after reduction, shifting from state 0 to state 9
loop
yyn:0  state:9  yychar:-1
 next yychar:304
state 9, shifting to state 6
loop
state 6, reducing 1 by rule 9 (external_declaration : NEWLINE)
reduce
after reduction, shifting from state 9 to state 23
loop
state 23, reducing 2 by rule 3 (program_unit : program_unit external_declaration)
reduce
after reduction, shifting from state 0 to state 9
loop
yyn:0  state:9  yychar:-1
 next yychar:304
state 9, shifting to state 6
loop
state 6, reducing 1 by rule 9 (external_declaration : NEWLINE)
reduce
after reduction, shifting from state 9 to state 23
loop
state 23, reducing 2 by rule 3 (program_unit : program_unit external_declaration)
reduce
after reduction, shifting from state 0 to state 9
loop
yyn:0  state:9  yychar:-1
 next yychar:257
state 9, shifting to state 1
loop
yyn:0  state:1  yychar:-1
 next yychar:308
state 1, shifting to state 17
loop
yyn:0  state:17  yychar:-1
 next yychar:298
state 17, shifting to state 25
loop
state 25, reducing 0 by rule 35 (params :)
reduce
after reduction, shifting from state 25 to state 54
loop
yyn:0  state:54  yychar:-1
 next yychar:308
reduce
state 54, reducing 0 by rule 14 (commaq :)
reduce
after reduction, shifting from state 54 to state 85
loop
yyn:0  state:85  yychar:308
state 85, shifting to state 32
loop
yyn:0  state:32  yychar:-1
 next yychar:304
reduce
state 32, reducing 1 by rule 28 (compound_identifier : IDENTIFIER)
reduce
after reduction, shifting from state 85 to state 41
loop
yyn:0  state:41  yychar:304
reduce
state 41, reducing 1 by rule 25 (identifier : compound_identifier)
reduce
after reduction, shifting from state 85 to state 40
loop
state 40, reducing 1 by rule 23 (primary_expression : identifier)
reduce
after reduction, shifting from state 85 to state 39
loop
state 39, reducing 1 by rule 29 (postfix_expression : primary_expression)
reduce
after reduction, shifting from state 85 to state 42
loop
yyn:0  state:42  yychar:304
reduce
state 42, reducing 1 by rule 37 (unary_expression : postfix_expression)
reduce
after reduction, shifting from state 85 to state 44
loop
state 44, reducing 1 by rule 47 (pow_expression : unary_expression)
reduce
after reduction, shifting from state 85 to state 47
loop
yyn:0  state:47  yychar:304
reduce
state 47, reducing 1 by rule 46 (multiplicative_expression : pow_expression)
reduce
after reduction, shifting from state 85 to state 46
loop
yyn:0  state:46  yychar:304
reduce
state 46, reducing 1 by rule 40 (additive_expression : multiplicative_expression)
reduce
after reduction, shifting from state 85 to state 45
loop
yyn:0  state:45  yychar:304
reduce
state 45, reducing 1 by rule 49 (relational_expression : additive_expression)
reduce
after reduction, shifting from state 85 to state 48
loop
yyn:0  state:48  yychar:304
reduce
state 48, reducing 1 by rule 54 (equality_expression : relational_expression)
reduce
after reduction, shifting from state 85 to state 49
loop
yyn:0  state:49  yychar:304
reduce
state 49, reducing 1 by rule 57 (logical_and_expression : equality_expression)
reduce
after reduction, shifting from state 85 to state 50
loop
yyn:0  state:50  yychar:304
reduce
state 50, reducing 1 by rule 59 (logical_or_expression : logical_and_expression)
reduce
after reduction, shifting from state 85 to state 51
loop
yyn:0  state:51  yychar:304
reduce
state 51, reducing 1 by rule 74 (expression_t : logical_or_expression)
reduce
after reduction, shifting from state 85 to state 52
loop
state 52, reducing 1 by rule 72 (expression : expression_t)
reduce
after reduction, shifting from state 85 to state 131
loop
state 131, reducing 1 by rule 36 (param : expression)
reduce
after reduction, shifting from state 85 to state 132
loop
state 132, reducing 3 by rule 34 (params : params commaq param)
reduce
after reduction, shifting from state 25 to state 54
loop
yyn:0  state:54  yychar:304
state 54, shifting to state 84
loop
yyn:0  state:84  yychar:-1
 next yychar:304
state 84, shifting to state 119
loop
state 119, reducing 1 by rule 67 (statement : NEWLINE)
reduce
after reduction, shifting from state 84 to state 124
loop
state 124, reducing 1 by rule 68 (statements : statement)
reduce
after reduction, shifting from state 84 to state 130
loop
yyn:0  state:130  yychar:-1
 next yychar:308
state 130, shifting to state 32
loop
yyn:0  state:32  yychar:-1
 next yychar:298
state 32, shifting to state 64
loop
state 64, reducing 0 by rule 35 (params :)
reduce
after reduction, shifting from state 64 to state 99
loop
yyn:0  state:99  yychar:-1
 next yychar:296
reduce
state 99, reducing 0 by rule 14 (commaq :)
reduce
after reduction, shifting from state 99 to state 85
loop
yyn:0  state:85  yychar:296
state 85, shifting to state 31
loop
yyn:0  state:31  yychar:-1
 next yychar:308
state 31, shifting to state 32
loop
yyn:0  state:32  yychar:-1
 next yychar:298
state 32, shifting to state 64
loop
state 64, reducing 0 by rule 35 (params :)
reduce
after reduction, shifting from state 64 to state 99
loop
yyn:0  state:99  yychar:-1
 next yychar:311
reduce
state 99, reducing 0 by rule 14 (commaq :)
reduce
after reduction, shifting from state 99 to state 85
loop
yyn:0  state:85  yychar:311
state 85, shifting to state 35
loop
state 35, reducing 1 by rule 11 (atom : NUMERIC)
reduce
after reduction, shifting from state 85 to state 37
loop
state 37, reducing 1 by rule 21 (primary_expression : atom)
reduce
after reduction, shifting from state 85 to state 39
loop
state 39, reducing 1 by rule 29 (postfix_expression : primary_expression)
reduce
after reduction, shifting from state 85 to state 42
loop
yyn:0  state:42  yychar:-1
 next yychar:311
reduce
state 42, reducing 1 by rule 37 (unary_expression : postfix_expression)
reduce
after reduction, shifting from state 85 to state 44
loop
state 44, reducing 1 by rule 47 (pow_expression : unary_expression)
reduce
after reduction, shifting from state 85 to state 47
loop
yyn:0  state:47  yychar:311
reduce
state 47, reducing 1 by rule 46 (multiplicative_expression : pow_expression)
reduce
after reduction, shifting from state 85 to state 46
loop
yyn:0  state:46  yychar:311
reduce
state 46, reducing 1 by rule 40 (additive_expression : multiplicative_expression)
reduce
after reduction, shifting from state 85 to state 45
loop
yyn:0  state:45  yychar:311
reduce
state 45, reducing 1 by rule 49 (relational_expression : additive_expression)
reduce
after reduction, shifting from state 85 to state 48
loop
yyn:0  state:48  yychar:311
reduce
state 48, reducing 1 by rule 54 (equality_expression : relational_expression)
reduce
after reduction, shifting from state 85 to state 49
loop
yyn:0  state:49  yychar:311
reduce
state 49, reducing 1 by rule 57 (logical_and_expression : equality_expression)
reduce
after reduction, shifting from state 85 to state 50
loop
yyn:0  state:50  yychar:311
reduce
state 50, reducing 1 by rule 59 (logical_or_expression : logical_and_expression)
reduce
after reduction, shifting from state 85 to state 51
loop
yyn:0  state:51  yychar:311
reduce
state 51, reducing 1 by rule 74 (expression_t : logical_or_expression)
reduce
after reduction, shifting from state 85 to state 52
loop
state 52, reducing 1 by rule 72 (expression : expression_t)
reduce
after reduction, shifting from state 85 to state 131
loop
state 131, reducing 1 by rule 36 (param : expression)
reduce
after reduction, shifting from state 85 to state 132
loop
state 132, reducing 3 by rule 34 (params : params commaq param)
reduce
after reduction, shifting from state 64 to state 99
loop
yyn:0  state:99  yychar:311
reduce
state 99, reducing 0 by rule 14 (commaq :)
reduce
after reduction, shifting from state 99 to state 85
loop
yyn:0  state:85  yychar:311
state 85, shifting to state 35
loop
state 35, reducing 1 by rule 11 (atom : NUMERIC)
reduce
after reduction, shifting from state 85 to state 37
loop
state 37, reducing 1 by rule 21 (primary_expression : atom)
reduce
after reduction, shifting from state 85 to state 39
loop
state 39, reducing 1 by rule 29 (postfix_expression : primary_expression)
reduce
after reduction, shifting from state 85 to state 42
loop
yyn:0  state:42  yychar:-1
 next yychar:297
reduce
state 42, reducing 1 by rule 37 (unary_expression : postfix_expression)
reduce
after reduction, shifting from state 85 to state 44
loop
state 44, reducing 1 by rule 47 (pow_expression : unary_expression)
reduce
after reduction, shifting from state 85 to state 47
loop
yyn:0  state:47  yychar:297
reduce
state 47, reducing 1 by rule 46 (multiplicative_expression : pow_expression)
reduce
after reduction, shifting from state 85 to state 46
loop
yyn:0  state:46  yychar:297
reduce
state 46, reducing 1 by rule 40 (additive_expression : multiplicative_expression)
reduce
after reduction, shifting from state 85 to state 45
loop
yyn:0  state:45  yychar:297
reduce
state 45, reducing 1 by rule 49 (relational_expression : additive_expression)
reduce
after reduction, shifting from state 85 to state 48
loop
yyn:0  state:48  yychar:297
reduce
state 48, reducing 1 by rule 54 (equality_expression : relational_expression)
reduce
after reduction, shifting from state 85 to state 49
loop
yyn:0  state:49  yychar:297
reduce
state 49, reducing 1 by rule 57 (logical_and_expression : equality_expression)
reduce
after reduction, shifting from state 85 to state 50
loop
yyn:0  state:50  yychar:297
reduce
state 50, reducing 1 by rule 59 (logical_or_expression : logical_and_expression)
reduce
after reduction, shifting from state 85 to state 51
loop
yyn:0  state:51  yychar:297
reduce
state 51, reducing 1 by rule 74 (expression_t : logical_or_expression)
reduce
after reduction, shifting from state 85 to state 52
loop
state 52, reducing 1 by rule 72 (expression : expression_t)
reduce
after reduction, shifting from state 85 to state 131
loop
state 131, reducing 1 by rule 36 (param : expression)
reduce
after reduction, shifting from state 85 to state 132
loop
state 132, reducing 3 by rule 34 (params : params commaq param)
reduce
after reduction, shifting from state 64 to state 99
loop
yyn:0  state:99  yychar:297
reduce
state 99, reducing 3 by rule 33 (function_expression : IDENTIFIER COLON params)
reduce
after reduction, shifting from state 31 to state 43
loop
state 43, reducing 1 by rule 32 (postfix_expression : function_expression)
reduce
after reduction, shifting from state 31 to state 42
loop
yyn:0  state:42  yychar:297
reduce
state 42, reducing 1 by rule 37 (unary_expression : postfix_expression)
reduce
after reduction, shifting from state 31 to state 44
loop
state 44, reducing 1 by rule 47 (pow_expression : unary_expression)
reduce
after reduction, shifting from state 31 to state 47
loop
yyn:0  state:47  yychar:297
reduce
state 47, reducing 1 by rule 46 (multiplicative_expression : pow_expression)
reduce
after reduction, shifting from state 31 to state 46
loop
yyn:0  state:46  yychar:297
reduce
state 46, reducing 1 by rule 40 (additive_expression : multiplicative_expression)
reduce
after reduction, shifting from state 31 to state 45
loop
yyn:0  state:45  yychar:297
reduce
state 45, reducing 1 by rule 49 (relational_expression : additive_expression)
reduce
after reduction, shifting from state 31 to state 48
loop
yyn:0  state:48  yychar:297
reduce
state 48, reducing 1 by rule 54 (equality_expression : relational_expression)
reduce
after reduction, shifting from state 31 to state 49
loop
yyn:0  state:49  yychar:297
reduce
state 49, reducing 1 by rule 57 (logical_and_expression : equality_expression)
reduce
after reduction, shifting from state 31 to state 50
loop
yyn:0  state:50  yychar:297
reduce
state 50, reducing 1 by rule 59 (logical_or_expression : logical_and_expression)
reduce
after reduction, shifting from state 31 to state 51
loop
yyn:0  state:51  yychar:297
reduce
state 51, reducing 1 by rule 74 (expression_t : logical_or_expression)
reduce
after reduction, shifting from state 31 to state 52
loop
state 52, reducing 1 by rule 72 (expression : expression_t)
reduce
after reduction, shifting from state 31 to state 61
loop
yyn:0  state:61  yychar:297
state 61, shifting to state 95
loop
state 95, reducing 3 by rule 24 (primary_expression : LPAREN expression RPAREN)
reduce
after reduction, shifting from state 85 to state 39
loop
state 39, reducing 1 by rule 29 (postfix_expression : primary_expression)
reduce
after reduction, shifting from state 85 to state 42
loop
yyn:0  state:42  yychar:-1
 next yychar:299
reduce
state 42, reducing 1 by rule 37 (unary_expression : postfix_expression)
reduce
after reduction, shifting from state 85 to state 44
loop
state 44, reducing 1 by rule 47 (pow_expression : unary_expression)
reduce
after reduction, shifting from state 85 to state 47
loop
yyn:0  state:47  yychar:299
reduce
state 47, reducing 1 by rule 46 (multiplicative_expression : pow_expression)
reduce
after reduction, shifting from state 85 to state 46
loop
yyn:0  state:46  yychar:299
reduce
state 46, reducing 1 by rule 40 (additive_expression : multiplicative_expression)
reduce
after reduction, shifting from state 85 to state 45
loop
yyn:0  state:45  yychar:299
reduce
state 45, reducing 1 by rule 49 (relational_expression : additive_expression)
reduce
after reduction, shifting from state 85 to state 48
loop
yyn:0  state:48  yychar:299
reduce
state 48, reducing 1 by rule 54 (equality_expression : relational_expression)
reduce
after reduction, shifting from state 85 to state 49
loop
yyn:0  state:49  yychar:299
reduce
state 49, reducing 1 by rule 57 (logical_and_expression : equality_expression)
reduce
after reduction, shifting from state 85 to state 50
loop
yyn:0  state:50  yychar:299
reduce
state 50, reducing 1 by rule 59 (logical_or_expression : logical_and_expression)
reduce
after reduction, shifting from state 85 to state 51
loop
yyn:0  state:51  yychar:299
reduce
state 51, reducing 1 by rule 74 (expression_t : logical_or_expression)
reduce
after reduction, shifting from state 85 to state 52
loop
state 52, reducing 1 by rule 72 (expression : expression_t)
reduce
after reduction, shifting from state 85 to state 131
loop
state 131, reducing 1 by rule 36 (param : expression)
reduce
after reduction, shifting from state 85 to state 132
loop
state 132, reducing 3 by rule 34 (params : params commaq param)
reduce
after reduction, shifting from state 64 to state 99
loop
yyn:0  state:99  yychar:299
state 99, shifting to state 83
loop
state 83, reducing 1 by rule 13 (commaq : COMMA)
reduce
after reduction, shifting from state 99 to state 85
loop
yyn:0  state:85  yychar:-1
 next yychar:308
state 85, shifting to state 32
loop
yyn:0  state:32  yychar:-1
 next yychar:300
reduce
state 32, reducing 1 by rule 28 (compound_identifier : IDENTIFIER)
reduce
after reduction, shifting from state 85 to state 41
loop
yyn:0  state:41  yychar:300
state 41, shifting to state 65
loop
yyn:0  state:65  yychar:-1
 next yychar:308
state 65, shifting to state 100
loop
state 100, reducing 3 by rule 27 (compound_identifier : compound_identifier DOT IDENTIFIER)
reduce
after reduction, shifting from state 85 to state 41
loop
yyn:0  state:41  yychar:-1
 next yychar:292
reduce
state 41, reducing 1 by rule 25 (identifier : compound_identifier)
reduce
after reduction, shifting from state 85 to state 40
loop
state 40, reducing 1 by rule 23 (primary_expression : identifier)
reduce
after reduction, shifting from state 85 to state 39
loop
state 39, reducing 1 by rule 29 (postfix_expression : primary_expression)
reduce
after reduction, shifting from state 85 to state 42
loop
yyn:0  state:42  yychar:292
reduce
state 42, reducing 1 by rule 37 (unary_expression : postfix_expression)
reduce
after reduction, shifting from state 85 to state 44
loop
state 44, reducing 1 by rule 47 (pow_expression : unary_expression)
reduce
after reduction, shifting from state 85 to state 47
loop
yyn:0  state:47  yychar:292
reduce
state 47, reducing 1 by rule 46 (multiplicative_expression : pow_expression)
reduce
after reduction, shifting from state 85 to state 46
loop
yyn:0  state:46  yychar:292
reduce
state 46, reducing 1 by rule 40 (additive_expression : multiplicative_expression)
reduce
after reduction, shifting from state 85 to state 45
loop
yyn:0  state:45  yychar:292
reduce
state 45, reducing 1 by rule 49 (relational_expression : additive_expression)
reduce
after reduction, shifting from state 85 to state 48
loop
yyn:0  state:48  yychar:292
reduce
state 48, reducing 1 by rule 54 (equality_expression : relational_expression)
reduce
after reduction, shifting from state 85 to state 49
loop
yyn:0  state:49  yychar:292
state 49, shifting to state 79
loop
yyn:0  state:79  yychar:-1
 next yychar:308
state 79, shifting to state 32
loop
yyn:0  state:32  yychar:-1
 next yychar:298
state 32, shifting to state 64
loop
state 64, reducing 0 by rule 35 (params :)
reduce
after reduction, shifting from state 64 to state 99
loop
yyn:0  state:99  yychar:-1
 next yychar:311
reduce
state 99, reducing 0 by rule 14 (commaq :)
reduce
after reduction, shifting from state 99 to state 85
loop
yyn:0  state:85  yychar:311
state 85, shifting to state 35
loop
state 35, reducing 1 by rule 11 (atom : NUMERIC)
reduce
after reduction, shifting from state 85 to state 37
loop
state 37, reducing 1 by rule 21 (primary_expression : atom)
reduce
after reduction, shifting from state 85 to state 39
loop
state 39, reducing 1 by rule 29 (postfix_expression : primary_expression)
reduce
after reduction, shifting from state 85 to state 42
loop
yyn:0  state:42  yychar:-1
 next yychar:311
reduce
state 42, reducing 1 by rule 37 (unary_expression : postfix_expression)
reduce
after reduction, shifting from state 85 to state 44
loop
state 44, reducing 1 by rule 47 (pow_expression : unary_expression)
reduce
after reduction, shifting from state 85 to state 47
loop
yyn:0  state:47  yychar:311
reduce
state 47, reducing 1 by rule 46 (multiplicative_expression : pow_expression)
reduce
after reduction, shifting from state 85 to state 46
loop
yyn:0  state:46  yychar:311
reduce
state 46, reducing 1 by rule 40 (additive_expression : multiplicative_expression)
reduce
after reduction, shifting from state 85 to state 45
loop
yyn:0  state:45  yychar:311
reduce
state 45, reducing 1 by rule 49 (relational_expression : additive_expression)
reduce
after reduction, shifting from state 85 to state 48
loop
yyn:0  state:48  yychar:311
reduce
state 48, reducing 1 by rule 54 (equality_expression : relational_expression)
reduce
after reduction, shifting from state 85 to state 49
loop
yyn:0  state:49  yychar:311
reduce
state 49, reducing 1 by rule 57 (logical_and_expression : equality_expression)
reduce
after reduction, shifting from state 85 to state 50
loop
yyn:0  state:50  yychar:311
reduce
state 50, reducing 1 by rule 59 (logical_or_expression : logical_and_expression)
reduce
after reduction, shifting from state 85 to state 51
loop
yyn:0  state:51  yychar:311
reduce
state 51, reducing 1 by rule 74 (expression_t : logical_or_expression)
reduce
after reduction, shifting from state 85 to state 52
loop
state 52, reducing 1 by rule 72 (expression : expression_t)
reduce
after reduction, shifting from state 85 to state 131
loop
state 131, reducing 1 by rule 36 (param : expression)
reduce
after reduction, shifting from state 85 to state 132
loop
state 132, reducing 3 by rule 34 (params : params commaq param)
reduce
after reduction, shifting from state 64 to state 99
loop
yyn:0  state:99  yychar:311
reduce
state 99, reducing 0 by rule 14 (commaq :)
reduce
after reduction, shifting from state 99 to state 85
loop
yyn:0  state:85  yychar:311
state 85, shifting to state 35
loop
state 35, reducing 1 by rule 11 (atom : NUMERIC)
reduce
after reduction, shifting from state 85 to state 37
loop
state 37, reducing 1 by rule 21 (primary_expression : atom)
reduce
after reduction, shifting from state 85 to state 39
loop
state 39, reducing 1 by rule 29 (postfix_expression : primary_expression)
reduce
after reduction, shifting from state 85 to state 42
loop
yyn:0  state:42  yychar:-1
 next yychar:304
reduce
state 42, reducing 1 by rule 37 (unary_expression : postfix_expression)
reduce
after reduction, shifting from state 85 to state 44
loop
state 44, reducing 1 by rule 47 (pow_expression : unary_expression)
reduce
after reduction, shifting from state 85 to state 47
loop
yyn:0  state:47  yychar:304
reduce
state 47, reducing 1 by rule 46 (multiplicative_expression : pow_expression)
reduce
after reduction, shifting from state 85 to state 46
loop
yyn:0  state:46  yychar:304
reduce
state 46, reducing 1 by rule 40 (additive_expression : multiplicative_expression)
reduce
after reduction, shifting from state 85 to state 45
loop
yyn:0  state:45  yychar:304
reduce
state 45, reducing 1 by rule 49 (relational_expression : additive_expression)
reduce
after reduction, shifting from state 85 to state 48
loop
yyn:0  state:48  yychar:304
reduce
state 48, reducing 1 by rule 54 (equality_expression : relational_expression)
reduce
after reduction, shifting from state 85 to state 49
loop
yyn:0  state:49  yychar:304
reduce
state 49, reducing 1 by rule 57 (logical_and_expression : equality_expression)
reduce
after reduction, shifting from state 85 to state 50
loop
yyn:0  state:50  yychar:304
reduce
state 50, reducing 1 by rule 59 (logical_or_expression : logical_and_expression)
reduce
after reduction, shifting from state 85 to state 51
loop
yyn:0  state:51  yychar:304
reduce
state 51, reducing 1 by rule 74 (expression_t : logical_or_expression)
reduce
after reduction, shifting from state 85 to state 52
loop
state 52, reducing 1 by rule 72 (expression : expression_t)
reduce
after reduction, shifting from state 85 to state 131
loop
state 131, reducing 1 by rule 36 (param : expression)
reduce
after reduction, shifting from state 85 to state 132
loop
state 132, reducing 3 by rule 34 (params : params commaq param)
reduce
after reduction, shifting from state 64 to state 99
loop
yyn:0  state:99  yychar:304
reduce
state 99, reducing 3 by rule 33 (function_expression : IDENTIFIER COLON params)
reduce
after reduction, shifting from state 79 to state 43
loop
state 43, reducing 1 by rule 32 (postfix_expression : function_expression)
reduce
after reduction, shifting from state 79 to state 42
loop
yyn:0  state:42  yychar:304
reduce
state 42, reducing 1 by rule 37 (unary_expression : postfix_expression)
reduce
after reduction, shifting from state 79 to state 44
loop
state 44, reducing 1 by rule 47 (pow_expression : unary_expression)
reduce
after reduction, shifting from state 79 to state 47
loop
yyn:0  state:47  yychar:304
reduce
state 47, reducing 1 by rule 46 (multiplicative_expression : pow_expression)
reduce
after reduction, shifting from state 79 to state 46
loop
yyn:0  state:46  yychar:304
reduce
state 46, reducing 1 by rule 40 (additive_expression : multiplicative_expression)
reduce
after reduction, shifting from state 79 to state 45
loop
yyn:0  state:45  yychar:304
reduce
state 45, reducing 1 by rule 49 (relational_expression : additive_expression)
reduce
after reduction, shifting from state 79 to state 112
loop
yyn:0  state:112  yychar:304
reduce
state 112, reducing 3 by rule 55 (equality_expression : equality_expression EQUALS relational_expression)
reduce
after reduction, shifting from state 85 to state 49
loop
yyn:0  state:49  yychar:304
reduce
state 49, reducing 1 by rule 57 (logical_and_expression : equality_expression)
reduce
after reduction, shifting from state 85 to state 50
loop
yyn:0  state:50  yychar:304
reduce
state 50, reducing 1 by rule 59 (logical_or_expression : logical_and_expression)
reduce
after reduction, shifting from state 85 to state 51
loop
yyn:0  state:51  yychar:304
reduce
state 51, reducing 1 by rule 74 (expression_t : logical_or_expression)
reduce
after reduction, shifting from state 85 to state 52
loop
state 52, reducing 1 by rule 72 (expression : expression_t)
reduce
after reduction, shifting from state 85 to state 131
loop
state 131, reducing 1 by rule 36 (param : expression)
reduce
after reduction, shifting from state 85 to state 132
loop
state 132, reducing 3 by rule 34 (params : params commaq param)
reduce
after reduction, shifting from state 64 to state 99
loop
yyn:0  state:99  yychar:304
reduce
state 99, reducing 3 by rule 33 (function_expression : IDENTIFIER COLON params)
reduce
after reduction, shifting from state 130 to state 43
loop
state 43, reducing 1 by rule 32 (postfix_expression : function_expression)
reduce
after reduction, shifting from state 130 to state 42
loop
yyn:0  state:42  yychar:304
reduce
state 42, reducing 1 by rule 37 (unary_expression : postfix_expression)
reduce
after reduction, shifting from state 130 to state 44
loop
state 44, reducing 1 by rule 47 (pow_expression : unary_expression)
reduce
after reduction, shifting from state 130 to state 47
loop
yyn:0  state:47  yychar:304
reduce
state 47, reducing 1 by rule 46 (multiplicative_expression : pow_expression)
reduce
after reduction, shifting from state 130 to state 46
loop
yyn:0  state:46  yychar:304
reduce
state 46, reducing 1 by rule 40 (additive_expression : multiplicative_expression)
reduce
after reduction, shifting from state 130 to state 45
loop
yyn:0  state:45  yychar:304
reduce
state 45, reducing 1 by rule 49 (relational_expression : additive_expression)
reduce
after reduction, shifting from state 130 to state 48
loop
yyn:0  state:48  yychar:304
reduce
state 48, reducing 1 by rule 54 (equality_expression : relational_expression)
reduce
after reduction, shifting from state 130 to state 49
loop
yyn:0  state:49  yychar:304
reduce
state 49, reducing 1 by rule 57 (logical_and_expression : equality_expression)
reduce
after reduction, shifting from state 130 to state 50
loop
yyn:0  state:50  yychar:304
reduce
state 50, reducing 1 by rule 59 (logical_or_expression : logical_and_expression)
reduce
after reduction, shifting from state 130 to state 51
loop
yyn:0  state:51  yychar:304
reduce
state 51, reducing 1 by rule 74 (expression_t : logical_or_expression)
reduce
after reduction, shifting from state 130 to state 52
loop
state 52, reducing 1 by rule 72 (expression : expression_t)
reduce
after reduction, shifting from state 130 to state 121
loop
state 121, reducing 1 by rule 71 (expression_statement : expression)
reduce
after reduction, shifting from state 130 to state 125
loop
yyn:0  state:125  yychar:304
state 125, shifting to state 151
loop
state 151, reducing 2 by rule 62 (statement : expression_statement NEWLINE)
reduce
after reduction, shifting from state 130 to state 156
loop
state 156, reducing 2 by rule 69 (statements : statements statement)
reduce
after reduction, shifting from state 84 to state 130
loop
yyn:0  state:130  yychar:-1
 next yychar:261
state 130, shifting to state 157
loop
yyn:0  state:157  yychar:-1
 next yychar:308
state 157, shifting to state 32
loop
yyn:0  state:32  yychar:-1
 next yychar:304
reduce
state 32, reducing 1 by rule 28 (compound_identifier : IDENTIFIER)
reduce
after reduction, shifting from state 157 to state 41
loop
yyn:0  state:41  yychar:304
reduce
state 41, reducing 1 by rule 25 (identifier : compound_identifier)
reduce
after reduction, shifting from state 157 to state 40
loop
state 40, reducing 1 by rule 23 (primary_expression : identifier)
reduce
after reduction, shifting from state 157 to state 39
loop
state 39, reducing 1 by rule 29 (postfix_expression : primary_expression)
reduce
after reduction, shifting from state 157 to state 42
loop
yyn:0  state:42  yychar:304
reduce
state 42, reducing 1 by rule 37 (unary_expression : postfix_expression)
reduce
after reduction, shifting from state 157 to state 44
loop
state 44, reducing 1 by rule 47 (pow_expression : unary_expression)
reduce
after reduction, shifting from state 157 to state 47
loop
yyn:0  state:47  yychar:304
reduce
state 47, reducing 1 by rule 46 (multiplicative_expression : pow_expression)
reduce
after reduction, shifting from state 157 to state 46
loop
yyn:0  state:46  yychar:304
reduce
state 46, reducing 1 by rule 40 (additive_expression : multiplicative_expression)
reduce
after reduction, shifting from state 157 to state 45
loop
yyn:0  state:45  yychar:304
reduce
state 45, reducing 1 by rule 49 (relational_expression : additive_expression)
reduce
after reduction, shifting from state 157 to state 48
loop
yyn:0  state:48  yychar:304
reduce
state 48, reducing 1 by rule 54 (equality_expression : relational_expression)
reduce
after reduction, shifting from state 157 to state 49
loop
yyn:0  state:49  yychar:304
reduce
state 49, reducing 1 by rule 57 (logical_and_expression : equality_expression)
reduce
after reduction, shifting from state 157 to state 50
loop
yyn:0  state:50  yychar:304
reduce
state 50, reducing 1 by rule 59 (logical_or_expression : logical_and_expression)
reduce
after reduction, shifting from state 157 to state 51
loop
yyn:0  state:51  yychar:304
reduce
state 51, reducing 1 by rule 74 (expression_t : logical_or_expression)
reduce
after reduction, shifting from state 157 to state 52
loop
state 52, reducing 1 by rule 72 (expression : expression_t)
reduce
after reduction, shifting from state 157 to state 170
loop
yyn:0  state:170  yychar:304
state 170, shifting to state 178
loop
state 178, reducing 3 by rule 94 (opt_return : RETURN expression NEWLINE)
reduce
after reduction, shifting from state 130 to state 158
loop
yyn:0  state:158  yychar:-1
 next yychar:263
state 158, shifting to state 171
loop
state 171, reducing 8 by rule 93 (function_declarator : TO IDENTIFIER COLON params NEWLINE statements opt_return END)
reduce
after reduction, shifting from state 9 to state 11
loop
state 11, reducing 1 by rule 4 (external_declaration : function_declarator)
reduce
after reduction, shifting from state 9 to state 23
loop
state 23, reducing 2 by rule 3 (program_unit : program_unit external_declaration)
reduce
after reduction, shifting from state 0 to state 9
loop
yyn:0  state:9  yychar:-1
 next yychar:304
state 9, shifting to state 6
loop
state 6, reducing 1 by rule 9 (external_declaration : NEWLINE)
reduce
after reduction, shifting from state 9 to state 23
loop
state 23, reducing 2 by rule 3 (program_unit : program_unit external_declaration)
reduce
after reduction, shifting from state 0 to state 9
loop
yyn:0  state:9  yychar:-1
 next yychar:304
state 9, shifting to state 6
loop
state 6, reducing 1 by rule 9 (external_declaration : NEWLINE)
reduce
after reduction, shifting from state 9 to state 23
loop
state 23, reducing 2 by rule 3 (program_unit : program_unit external_declaration)
reduce
after reduction, shifting from state 0 to state 9
loop
yyn:0  state:9  yychar:-1
 next yychar:273
state 9, shifting to state 4
loop
state 4, reducing 1 by rule 91 (time_seq : BEFORE)
reduce
after reduction, shifting from state 9 to state 16
loop
yyn:0  state:16  yychar:-1
 next yychar:306
state 16, shifting to state 24
loop
yyn:0  state:24  yychar:-1
 next yychar:298
state 24, shifting to state 53
loop
yyn:0  state:53  yychar:-1
 next yychar:304
state 53, shifting to state 82
loop
yyn:0  state:82  yychar:-1
 next yychar:308
state 82, shifting to state 32
loop
yyn:0  state:32  yychar:-1
 next yychar:298
state 32, shifting to state 64
loop
state 64, reducing 0 by rule 35 (params :)
reduce
after reduction, shifting from state 64 to state 99
loop
yyn:0  state:99  yychar:-1
 next yychar:310
reduce
state 99, reducing 0 by rule 14 (commaq :)
reduce
after reduction, shifting from state 99 to state 85
loop
yyn:0  state:85  yychar:310
state 85, shifting to state 34
loop
state 34, reducing 1 by rule 12 (atom : STRING)
reduce
after reduction, shifting from state 85 to state 37
loop
state 37, reducing 1 by rule 21 (primary_expression : atom)
reduce
after reduction, shifting from state 85 to state 39
loop
state 39, reducing 1 by rule 29 (postfix_expression : primary_expression)
reduce
after reduction, shifting from state 85 to state 42
loop
yyn:0  state:42  yychar:-1
 next yychar:279
reduce
state 42, reducing 1 by rule 37 (unary_expression : postfix_expression)
reduce
after reduction, shifting from state 85 to state 44
loop
state 44, reducing 1 by rule 47 (pow_expression : unary_expression)
reduce
after reduction, shifting from state 85 to state 47
loop
yyn:0  state:47  yychar:279
reduce
state 47, reducing 1 by rule 46 (multiplicative_expression : pow_expression)
reduce
after reduction, shifting from state 85 to state 46
loop
yyn:0  state:46  yychar:279
reduce
state 46, reducing 1 by rule 40 (additive_expression : multiplicative_expression)
reduce
after reduction, shifting from state 85 to state 45
loop
yyn:0  state:45  yychar:279
state 45, shifting to state 68
loop
yyn:0  state:68  yychar:-1
 next yychar:308
state 68, shifting to state 32
loop
yyn:0  state:32  yychar:-1
 next yychar:304
reduce
state 32, reducing 1 by rule 28 (compound_identifier : IDENTIFIER)
reduce
after reduction, shifting from state 68 to state 41
loop
yyn:0  state:41  yychar:304
reduce
state 41, reducing 1 by rule 25 (identifier : compound_identifier)
reduce
after reduction, shifting from state 68 to state 40
loop
state 40, reducing 1 by rule 23 (primary_expression : identifier)
reduce
after reduction, shifting from state 68 to state 39
loop
state 39, reducing 1 by rule 29 (postfix_expression : primary_expression)
reduce
after reduction, shifting from state 68 to state 42
loop
yyn:0  state:42  yychar:304
reduce
state 42, reducing 1 by rule 37 (unary_expression : postfix_expression)
reduce
after reduction, shifting from state 68 to state 44
loop
state 44, reducing 1 by rule 47 (pow_expression : unary_expression)
reduce
after reduction, shifting from state 68 to state 47
loop
yyn:0  state:47  yychar:304
reduce
state 47, reducing 1 by rule 46 (multiplicative_expression : pow_expression)
reduce
after reduction, shifting from state 68 to state 101
loop
yyn:0  state:101  yychar:304
reduce
state 101, reducing 3 by rule 41 (additive_expression : additive_expression PLUS multiplicative_expression)
reduce
after reduction, shifting from state 85 to state 45
loop
yyn:0  state:45  yychar:304
reduce
state 45, reducing 1 by rule 49 (relational_expression : additive_expression)
reduce
after reduction, shifting from state 85 to state 48
loop
yyn:0  state:48  yychar:304
reduce
state 48, reducing 1 by rule 54 (equality_expression : relational_expression)
reduce
after reduction, shifting from state 85 to state 49
loop
yyn:0  state:49  yychar:304
reduce
state 49, reducing 1 by rule 57 (logical_and_expression : equality_expression)
reduce
after reduction, shifting from state 85 to state 50
loop
yyn:0  state:50  yychar:304
reduce
state 50, reducing 1 by rule 59 (logical_or_expression : logical_and_expression)
reduce
after reduction, shifting from state 85 to state 51
loop
yyn:0  state:51  yychar:304
reduce
state 51, reducing 1 by rule 74 (expression_t : logical_or_expression)
reduce
after reduction, shifting from state 85 to state 52
loop
state 52, reducing 1 by rule 72 (expression : expression_t)
reduce
after reduction, shifting from state 85 to state 131
loop
state 131, reducing 1 by rule 36 (param : expression)
reduce
after reduction, shifting from state 85 to state 132
loop
state 132, reducing 3 by rule 34 (params : params commaq param)
reduce
after reduction, shifting from state 64 to state 99
loop
yyn:0  state:99  yychar:304
reduce
state 99, reducing 3 by rule 33 (function_expression : IDENTIFIER COLON params)
reduce
after reduction, shifting from state 82 to state 43
loop
state 43, reducing 1 by rule 32 (postfix_expression : function_expression)
reduce
after reduction, shifting from state 82 to state 42
loop
yyn:0  state:42  yychar:304
reduce
state 42, reducing 1 by rule 37 (unary_expression : postfix_expression)
reduce
after reduction, shifting from state 82 to state 44
loop
state 44, reducing 1 by rule 47 (pow_expression : unary_expression)
reduce
after reduction, shifting from state 82 to state 47
loop
yyn:0  state:47  yychar:304
reduce
state 47, reducing 1 by rule 46 (multiplicative_expression : pow_expression)
reduce
after reduction, shifting from state 82 to state 46
loop
yyn:0  state:46  yychar:304
reduce
state 46, reducing 1 by rule 40 (additive_expression : multiplicative_expression)
reduce
after reduction, shifting from state 82 to state 45
loop
yyn:0  state:45  yychar:304
reduce
state 45, reducing 1 by rule 49 (relational_expression : additive_expression)
reduce
after reduction, shifting from state 82 to state 48
loop
yyn:0  state:48  yychar:304
reduce
state 48, reducing 1 by rule 54 (equality_expression : relational_expression)
reduce
after reduction, shifting from state 82 to state 49
loop
yyn:0  state:49  yychar:304
reduce
state 49, reducing 1 by rule 57 (logical_and_expression : equality_expression)
reduce
after reduction, shifting from state 82 to state 50
loop
yyn:0  state:50  yychar:304
reduce
state 50, reducing 1 by rule 59 (logical_or_expression : logical_and_expression)
reduce
after reduction, shifting from state 82 to state 51
loop
yyn:0  state:51  yychar:304
reduce
state 51, reducing 1 by rule 74 (expression_t : logical_or_expression)
reduce
after reduction, shifting from state 82 to state 52
loop
state 52, reducing 1 by rule 72 (expression : expression_t)
reduce
after reduction, shifting from state 82 to state 121
loop
state 121, reducing 1 by rule 71 (expression_statement : expression)
reduce
after reduction, shifting from state 82 to state 125
loop
yyn:0  state:125  yychar:304
state 125, shifting to state 151
loop
state 151, reducing 2 by rule 62 (statement : expression_statement NEWLINE)
reduce
after reduction, shifting from state 82 to state 124
loop
state 124, reducing 1 by rule 68 (statements : statement)
reduce
after reduction, shifting from state 82 to state 129
loop
yyn:0  state:129  yychar:-1
 next yychar:263
state 129, shifting to state 155
loop
state 155, reducing 6 by rule 90 (debug_hook_declarator : time_seq EVENT_NAME_IDENTIFIER COLON NEWLINE statements END)
reduce
after reduction, shifting from state 9 to state 14
loop
state 14, reducing 1 by rule 7 (external_declaration : debug_hook_declarator)
reduce
after reduction, shifting from state 9 to state 23
loop
state 23, reducing 2 by rule 3 (program_unit : program_unit external_declaration)
reduce
after reduction, shifting from state 0 to state 9
loop
yyn:0  state:9  yychar:-1
 next yychar:304
state 9, shifting to state 6
loop
state 6, reducing 1 by rule 9 (external_declaration : NEWLINE)
reduce
after reduction, shifting from state 9 to state 23
loop
state 23, reducing 2 by rule 3 (program_unit : program_unit external_declaration)
reduce
after reduction, shifting from state 0 to state 9
loop
yyn:0  state:9  yychar:-1
 next yychar:304
state 9, shifting to state 6
loop
state 6, reducing 1 by rule 9 (external_declaration : NEWLINE)
reduce
after reduction, shifting from state 9 to state 23
loop
state 23, reducing 2 by rule 3 (program_unit : program_unit external_declaration)
reduce
after reduction, shifting from state 0 to state 9
loop
yyn:0  state:9  yychar:-1
 next yychar:274
state 9, shifting to state 5
loop
state 5, reducing 1 by rule 92 (time_seq : AFTER)
reduce
after reduction, shifting from state 9 to state 16
loop
yyn:0  state:16  yychar:-1
 next yychar:306
state 16, shifting to state 24
loop
yyn:0  state:24  yychar:-1
 next yychar:298
state 24, shifting to state 53
loop
yyn:0  state:53  yychar:-1
 next yychar:304
state 53, shifting to state 82
loop
yyn:0  state:82  yychar:-1
 next yychar:308
state 82, shifting to state 32
loop
yyn:0  state:32  yychar:-1
 next yychar:298
state 32, shifting to state 64
loop
state 64, reducing 0 by rule 35 (params :)
reduce
after reduction, shifting from state 64 to state 99
loop
yyn:0  state:99  yychar:-1
 next yychar:310
reduce
state 99, reducing 0 by rule 14 (commaq :)
reduce
after reduction, shifting from state 99 to state 85
loop
yyn:0  state:85  yychar:310
state 85, shifting to state 34
loop
state 34, reducing 1 by rule 12 (atom : STRING)
reduce
after reduction, shifting from state 85 to state 37
loop
state 37, reducing 1 by rule 21 (primary_expression : atom)
reduce
after reduction, shifting from state 85 to state 39
loop
state 39, reducing 1 by rule 29 (postfix_expression : primary_expression)
reduce
after reduction, shifting from state 85 to state 42
loop
yyn:0  state:42  yychar:-1
 next yychar:304
reduce
state 42, reducing 1 by rule 37 (unary_expression : postfix_expression)
reduce
after reduction, shifting from state 85 to state 44
loop
state 44, reducing 1 by rule 47 (pow_expression : unary_expression)
reduce
after reduction, shifting from state 85 to state 47
loop
yyn:0  state:47  yychar:304
reduce
state 47, reducing 1 by rule 46 (multiplicative_expression : pow_expression)
reduce
after reduction, shifting from state 85 to state 46
loop
yyn:0  state:46  yychar:304
reduce
state 46, reducing 1 by rule 40 (additive_expression : multiplicative_expression)
reduce
after reduction, shifting from state 85 to state 45
loop
yyn:0  state:45  yychar:304
reduce
state 45, reducing 1 by rule 49 (relational_expression : additive_expression)
reduce
after reduction, shifting from state 85 to state 48
loop
yyn:0  state:48  yychar:304
reduce
state 48, reducing 1 by rule 54 (equality_expression : relational_expression)
reduce
after reduction, shifting from state 85 to state 49
loop
yyn:0  state:49  yychar:304
reduce
state 49, reducing 1 by rule 57 (logical_and_expression : equality_expression)
reduce
after reduction, shifting from state 85 to state 50
loop
yyn:0  state:50  yychar:304
reduce
state 50, reducing 1 by rule 59 (logical_or_expression : logical_and_expression)
reduce
after reduction, shifting from state 85 to state 51
loop
yyn:0  state:51  yychar:304
reduce
state 51, reducing 1 by rule 74 (expression_t : logical_or_expression)
reduce
after reduction, shifting from state 85 to state 52
loop
state 52, reducing 1 by rule 72 (expression : expression_t)
reduce
after reduction, shifting from state 85 to state 131
loop
state 131, reducing 1 by rule 36 (param : expression)
reduce
after reduction, shifting from state 85 to state 132
loop
state 132, reducing 3 by rule 34 (params : params commaq param)
reduce
after reduction, shifting from state 64 to state 99
loop
yyn:0  state:99  yychar:304
reduce
state 99, reducing 3 by rule 33 (function_expression : IDENTIFIER COLON params)
reduce
after reduction, shifting from state 82 to state 43
loop
state 43, reducing 1 by rule 32 (postfix_expression : function_expression)
reduce
after reduction, shifting from state 82 to state 42
loop
yyn:0  state:42  yychar:304
reduce
state 42, reducing 1 by rule 37 (unary_expression : postfix_expression)
reduce
after reduction, shifting from state 82 to state 44
loop
state 44, reducing 1 by rule 47 (pow_expression : unary_expression)
reduce
after reduction, shifting from state 82 to state 47
loop
yyn:0  state:47  yychar:304
reduce
state 47, reducing 1 by rule 46 (multiplicative_expression : pow_expression)
reduce
after reduction, shifting from state 82 to state 46
loop
yyn:0  state:46  yychar:304
reduce
state 46, reducing 1 by rule 40 (additive_expression : multiplicative_expression)
reduce
after reduction, shifting from state 82 to state 45
loop
yyn:0  state:45  yychar:304
reduce
state 45, reducing 1 by rule 49 (relational_expression : additive_expression)
reduce
after reduction, shifting from state 82 to state 48
loop
yyn:0  state:48  yychar:304
reduce
state 48, reducing 1 by rule 54 (equality_expression : relational_expression)
reduce
after reduction, shifting from state 82 to state 49
loop
yyn:0  state:49  yychar:304
reduce
state 49, reducing 1 by rule 57 (logical_and_expression : equality_expression)
reduce
after reduction, shifting from state 82 to state 50
loop
yyn:0  state:50  yychar:304
reduce
state 50, reducing 1 by rule 59 (logical_or_expression : logical_and_expression)
reduce
after reduction, shifting from state 82 to state 51
loop
yyn:0  state:51  yychar:304
reduce
state 51, reducing 1 by rule 74 (expression_t : logical_or_expression)
reduce
after reduction, shifting from state 82 to state 52
loop
state 52, reducing 1 by rule 72 (expression : expression_t)
reduce
after reduction, shifting from state 82 to state 121
loop
state 121, reducing 1 by rule 71 (expression_statement : expression)
reduce
after reduction, shifting from state 82 to state 125
loop
yyn:0  state:125  yychar:304
state 125, shifting to state 151
loop
state 151, reducing 2 by rule 62 (statement : expression_statement NEWLINE)
reduce
after reduction, shifting from state 82 to state 124
loop
state 124, reducing 1 by rule 68 (statements : statement)
reduce
after reduction, shifting from state 82 to state 129
loop
yyn:0  state:129  yychar:-1
 next yychar:259
state 129, shifting to state 116
loop
yyn:0  state:116  yychar:-1
 next yychar:308
state 116, shifting to state 88
loop
state 88, reducing 1 by rule 28 (compound_identifier : IDENTIFIER)
reduce
after reduction, shifting from state 116 to state 41
loop
yyn:0  state:41  yychar:-1
 next yychar:276
reduce
state 41, reducing 1 by rule 25 (identifier : compound_identifier)
reduce
after reduction, shifting from state 116 to state 145
loop
yyn:0  state:145  yychar:276
state 145, shifting to state 164
loop
yyn:0  state:164  yychar:-1
 next yychar:309
state 164, shifting to state 33
loop
state 33, reducing 1 by rule 26 (identifier : SYS_IDENTIFIER)
reduce
after reduction, shifting from state 164 to state 173
loop
state 173, reducing 2 by rule 84 (in_statement : IN identifier)
reduce
after reduction, shifting from state 145 to state 165
loop
yyn:0  state:165  yychar:-1
 next yychar:304
reduce
state 165, reducing 0 by rule 83 (as_statement :)
reduce
after reduction, shifting from state 165 to state 175
loop
yyn:0  state:175  yychar:304
reduce
state 175, reducing 0 by rule 87 (from_statement :)
