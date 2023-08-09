import java.util.ArrayList;
import java.util.List;

public class ParseTreeExample {

    public static void main(String[] args) {
        String input = "2 * (3 + 4)";
        ParseNode root = parseExpr(input);
        System.out.println(root.toString());
    }

    private static ParseNode parseExpr(String input) {
        // Create a root node for the parse tree
        ParseNode root = new ParseNode("expr");

        // Split the input into tokens
        String[] tokens = input.split(" ");

        // Create child nodes for each token
        for (String token : tokens) {
            ParseNode child = new ParseNode(token);
            root.addChild(child);
        }

        // Return the root node
        return root;
    }

    private static class ParseNode {
        private String name;
        private List<ParseNode> children;

        public ParseNode(String name) {
            this.name = name;
            this.children = new ArrayList<>();
        }

        public void addChild(ParseNode child) {
            children.add(child);
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("(");
            sb.append(name);
            for (ParseNode child : children) {
                sb.append(" ");
                sb.append(child.toString());
            }
            sb.append(")");
            return sb.toString();
        }
    }
}
