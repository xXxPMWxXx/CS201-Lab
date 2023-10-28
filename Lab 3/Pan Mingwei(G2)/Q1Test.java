/*
 * Name:Pan Mingwei
 * Email ID:mingwei.pan.2022
 */

public class Q1Test {
     public static void main(String[] args) {

          String result, traversal1, traversal2, traversal3;

          traversal1 = "1-2";
          traversal2 = "2-1-3";
          traversal3 = "1-3-2";
          result = verify(traversal1, traversal2, traversal3);
          System.out.println("Traversal 1 : " + traversal1);
          System.out.println("Traversal 2 : " + traversal2);
          System.out.println("Traversal 3 : " + traversal3);
          System.out.println("Expected Result : Invalid traversals");
          System.out.println("  Actual Result : " + result);
          System.out.println();

          traversal1 = "1-2-3";
          traversal2 = "2-1-3";
          traversal3 = "1-3-2";
          result = verify(traversal1, traversal2, traversal3);
          System.out.println("Traversal 1 : " + traversal1);
          System.out.println("Traversal 2 : " + traversal2);
          System.out.println("Traversal 3 : " + traversal3);
          System.out.println(
                    "Expected Result : Traversal 1 - Inorder, Traversal 2 - Preorder, Traversal 3 - Postorder");
          System.out.println("  Actual Result : " + result);
          System.out.println();

          traversal1 = "1-2-3";
          traversal2 = "3-2-1";
          traversal3 = "2-3-1";
          result = verify(traversal1, traversal2, traversal3);
          System.out.println("Traversal 1 : " + traversal1);
          System.out.println("Traversal 2 : " + traversal2);
          System.out.println("Traversal 3 : " + traversal3);
          System.out.println("Expected Result : Invalid traversals");
          System.out.println("  Actual Result : " + result);
          System.out.println();

          traversal1 = "3-1-2-5-4";
          traversal2 = "2-1-4-5-3";
          traversal3 = "1-2-3-4-5";
          result = verify(traversal1, traversal2, traversal3);
          System.out.println("Traversal 1 : " + traversal1);
          System.out.println("Traversal 2 : " + traversal2);
          System.out.println("Traversal 3 : " + traversal3);
          System.out.println(
                    "Expected Result : Traversal 1 - Preorder, Traversal 2 - Postorder, Traversal 3 - Inorder");
          System.out.println("  Actual Result : " + result);
          System.out.println();

          traversal1 = "10-20-30-40-50";
          traversal2 = "20-10-30-40-50";
          traversal3 = "10-50-40-30-20";
          result = verify(traversal1, traversal2, traversal3);
          System.out.println("Traversal 1 : " + traversal1);
          System.out.println("Traversal 2 : " + traversal2);
          System.out.println("Traversal 3 : " + traversal3);
          System.out.println(
                    "Expected Result : Traversal 1 - Inorder, Traversal 2 - Preorder, Traversal 3 - Postorder");
          System.out.println("  Actual Result : " + result);
          System.out.println();
     }

     public static String verify(String traversal1, String traversal2, String traversal3) {

          // check if they have the same number of elements
          int length1 = traversal1.split("-").length;
          int length2 = traversal2.split("-").length;
          int length3 = traversal3.split("-").length;
          if (length1 != length2 || length1 != length3 || length2 != length3) {
               return "Invalid traversals";
          }

          String whatIsTraversal1 = "";
          String whatIsTraversal2 = "";
          String whatIsTraversal3 = "";

          // find which is inorder
          int inorder = findWhichIsInorder(traversal1, traversal2, traversal3);
          // to store the inorder traversal for checking
          String inorderString = "";
          if (inorder == -1) {
               return "Invalid traversals";
          }

          if (inorder == 1) {
               whatIsTraversal1 = "Inorder";
               inorderString = traversal1;
          } else if (inorder == 2) {
               whatIsTraversal2 = "Inorder";
               inorderString = traversal2;
          } else {
               whatIsTraversal3 = "Inorder";
               inorderString = traversal3;
          }

          // Store the other two traversal and identify which traversal they are
          String input1String = "";
          int input1TraversalOrder = -1;
          String input2String = "";
          int input2TraversalOrder = -1;
          if (inorder == 1) {
               input1String = traversal2;
               input1TraversalOrder = 2;
               input2String = traversal3;
               input2TraversalOrder = 3;
          } else if (inorder == 2) {
               input1String = traversal1;
               input1TraversalOrder = 1;
               input2String = traversal3;
               input2TraversalOrder = 3;
          } else {
               input1String = traversal1;
               input1TraversalOrder = 1;
               input2String = traversal2;
               input2TraversalOrder = 2;
          }
          // means they are not valid BST
          if (!isBSTPossible(input1String, input2String, inorderString)
                    && !isBSTPossible(input2String, input1String, inorderString)) {
               return "Invalid traversals";
          }
          // determine which is preorder and postorder
          int preorder = -1;
          int postorder = -1;
          if (isBSTPossible(input1String, input2String, inorderString)) {
               preorder = input1TraversalOrder;
               postorder = input2TraversalOrder;
          } else {
               preorder = input2TraversalOrder;
               postorder = input1TraversalOrder;
          }
          // To determine which traversal is preorder and postorder, for output
          if (preorder == 1) {
               whatIsTraversal1 = "Preorder";
          } else if (preorder == 2) {
               whatIsTraversal2 = "Preorder";
          } else {
               whatIsTraversal3 = "Preorder";
          }
          if (postorder == 1) {
               whatIsTraversal1 = "Postorder";
          } else if (postorder == 2) {
               whatIsTraversal2 = "Postorder";
          } else {
               whatIsTraversal3 = "Postorder";
          }
          // String format the output
          String output = String.format("Traversal 1 - %s, Traversal 2 - %s, Traversal 3 - %s", whatIsTraversal1,
                    whatIsTraversal2, whatIsTraversal3);
          return output;
     }

     // To check for inorder
     public static int findWhichIsInorder(String traversal1, String traversal2, String traversal3) {
          // to find which is inorder
          int numOfInorder = 0;
          int inorder = -1;
          if (isStringInorder(traversal1)) {
               numOfInorder++;
               inorder = 1;
          }

          if (isStringInorder(traversal2)) {
               numOfInorder++;
               inorder = 2;
          }

          if (isStringInorder(traversal3)) {
               numOfInorder++;
               inorder = 3;
          }

          if (numOfInorder != 1) {
               return -1;
          }

          return inorder;
     }

     public static boolean isStringInorder(String traversal) {
          String[] nodes = traversal.split("-");
          int n = nodes.length;
          // if only one element is always valid
          if (n <= 1) {
               return true;
          }

          int prev = Integer.parseInt(nodes[0]);

          for (int i = 1; i < n; i++) {
               int current = Integer.parseInt(nodes[i]);
               if (current <= prev) {
                    return false;
               }
               prev = current;
          }

          return true;
     }

     // To check if the preorder and the postorder from the same BST
     public static boolean isBSTPossible(String preorder, String postorder, String inorder) {
          BST bst = new BST();
          // will build the BST based on preorder
          bst.buildBSTFromPreorder(preorder);
          // get the inorder from the BST & remove the ending -
          String BSTInorder = bst.inOrderTraversal(bst.getRoot());
          BSTInorder = BSTInorder.substring(0, BSTInorder.length() - 1);
          //check for inorder first, in case they provide inorder like : 1-2-5
          if (!inorder.equals(BSTInorder)) {
               return false;
          }
          
          // get the postorder from the BST & remove the ending -
          String BSTPostorder = bst.postOrderTraversal(bst.getRoot());
          BSTPostorder = BSTPostorder.substring(0, BSTPostorder.length() - 1);
          // check if the postorder of the BST match with the input postorder and the
          if (postorder.equals(BSTPostorder)) {
                    return true;
          }
          return false;
     }

}