import java.util.*;

public class ResolutionAlgorithm {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Entrez la formule sous forme de clauses (utilisez les opérateurs logiques '&' pour ET, '|' pour OU et '~' pour NON, séparées par des virgules) :");
        String input = scanner.nextLine();

        String[] clauses = input.split(",");
        
        boolean isValid = isFormulaValid(clauses);

        if (isValid) {
            System.out.println("La formule est valide.");
        } else {
            System.out.println("La formule n'est pas valide.");
        }

        scanner.close();
    }

    public static boolean isFormulaValid(String[] clauses) {
        List<Set<Character>> clauseSetList = new ArrayList<>();
    
        for (String clause : clauses) {
            Set<Character> clauseSet = new HashSet<>();
            for (int i = 0; i < clause.length(); i++) {
                char literal = clause.charAt(i);
                if (Character.isLetter(literal)) {
                    clauseSet.add(literal);
                }
            }
            clauseSetList.add(clauseSet);
        }
    
        boolean progress = true;
    
        while (progress) {
            progress = false;
            Set<Set<Character>> newClauses = new HashSet<>();
    
            for (int i = 0; i < clauseSetList.size(); i++) {
                for (int j = i + 1; j < clauseSetList.size(); j++) {
                    Set<Character> resolved = resolve(clauseSetList.get(i), clauseSetList.get(j));
                    if (resolved != null && !resolved.isEmpty()) {
                        newClauses.add(resolved);
                        progress = true;
                        System.out.println("Nouvelle clause ajoutée : " + resolved);
                        // Supprimer les deux clauses résolues
                        clauseSetList.remove(clauseSetList.get(i));
                        clauseSetList.remove(clauseSetList.get(j - 1));
                        break; // Sortir de la boucle interne
                    } else if (resolved != null && resolved.isEmpty()) {
                        System.out.println("Clause vide trouvée, formule valide.");
                        return true; // Clause vide, formule valide
                    }
                }
                if (progress) {
                    break; // Sortir de la boucle externe si une nouvelle clause a été ajoutée
                }
            }
    
            clauseSetList.addAll(newClauses);
    
            // Vérifier si la dernière clause résolue est vide
            if (newClauses.isEmpty() && !clauseSetList.isEmpty()) {
                Set<Character> lastClause = clauseSetList.get(clauseSetList.size() - 1);
                if (lastClause.isEmpty()) {
                    System.out.println("Dernière clause résolue vide, formule valide.");
                    return true;
                } else {
                    System.out.println("Dernière clause résolue non vide, formule invalide.");
                    return false;
                }
            }
        }
    
        // Si la boucle se termine sans produire de clause vide, la formule est invalide
        System.out.println("Aucune clause vide trouvée, formule invalide.");
        return false;
    }
    
    
    
    public static Set<Character> resolve(Set<Character> clause1, Set<Character> clause2) {
        Set<Character> resolved = new HashSet<>(clause1);
    
        for (Character literal : clause2) {
            char negation = (literal == '~') ? ' ' : (Character.toLowerCase(literal) == ' ') ? '~' : Character.toLowerCase(literal);
            char positive = (literal == '~') ? Character.toLowerCase(literal) : ' ';
            if (resolved.contains(negation)) {
                resolved.remove(negation);
                resolved.remove(positive);
                return resolved.isEmpty() ? null : resolved; // Si les deux sont présents, ils s'annulent
            }
        }
    
        System.out.println("Clauses résolues : " + resolved); // Message de débogage
    
        return resolved;
    }
}
