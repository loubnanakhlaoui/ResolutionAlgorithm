# ResolutionAlgorithm

## Description:
ResolutionAlgorithm is a Java program that checks the validity of propositional logic formulas represented as sets of clauses using the resolution method.

## Features:
Accepts input formulas in conjunctive normal form (CNF), represented as sets of clauses separated by commas.
Supports logical operators & for AND, | for OR, and ~ for NOT.
Uses the resolution method to check the validity of the input formula.
Outputs whether the formula is valid or not.

## Usage:
Compile the Java file: javac ResolutionAlgorithm.java
Run the compiled program: java ResolutionAlgorithm
Enter the formula in conjunctive normal form (CNF) when prompted.
The program will output whether the formula is valid or not.

## Example:
$ java ResolutionAlgorithm
Entrez la formule en FCN sous forme de clauses (utilisez les opérateurs logiques '&' pour ET, '|' pour OU et '~' pour NON, séparées par des virgules) :
~P,P,Q
La formule n'est pas valide.

## Input Format:
The program accepts propositional logic formulas in conjunctive normal form (CNF), represented as sets of clauses separated by commas. Each clause consists of literals (variables or negations of variables) combined using logical operators.

## Output:
If the formula is valid, the program outputs: "La formule est valide."
If the formula is not valid, the program outputs: "La formule n'est pas valide."

## Resolution Method: 
The resolution rule states that if there exist two clauses, one containing a literal L and another containing the negation of that literal ¬L, then their resolvent can be derived by removing L and ¬L from the respective clauses and combining the remaining literals.

After applying the resolution rule, a new clause is generated containing all the literals from the two original clauses except for the complementary literals that were resolved. This new clause is added to the set of existing clauses.

We stop the resolution algorithm when we either detect a contradiction (empty clause) or no new clauses can be generated.
## Loubna NAKHLAOUI


