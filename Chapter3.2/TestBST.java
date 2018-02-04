
public class TestBST {
    public static void main(String[] args) {
        BST<String, Integer> bst = new BST<>();
        String[] ts = {"E", "D", "A", "Q", "J", "M", "T", "S"};
        int i = 0;
        for (String key : ts)
            bst.put(key, i++);
        for (String s : bst.keys())
            System.out.println(s + " " + bst.get(s));

        // Test min()
        System.out.print("Test min: ");
        System.out.println(bst.min() == "A");
        // Test max()
        System.out.print("Test max: ");
        System.out.println(bst.max() == "T");
        // Test floor()
        System.out.print("Test floor: ");
        System.out.print(bst.floor("Q") == "Q");
        System.out.println(bst.floor("R") == "Q");
        // Test ceiling()
        System.out.print("Test ceiling: ");
        System.out.print(bst.ceiling("Q") == "Q");
        System.out.println(bst.ceiling("R") == "S");
        // Test select()
        System.out.print("Test select: ");
        System.out.println(bst.select(5) == "Q" );
        // Test rank()
        //System.out.print("Test rank: ");
        //System.out.println(bst.rank("J") == 4);

        System.out.println("Size: " + bst.size() + " Height: " + bst.height());
        System.out.println("HeightRec: " + bst.heightRec());
        // Test deleteMin()
        System.out.println("After 3 deleteMin");
        bst.deleteMin();
        for (String s : bst.keys())
            System.out.println(s + " " + bst.get(s));
        System.out.println("Size: " + bst.size() + " Height: " + bst.height());
        System.out.println("HeightRec: " + bst.heightRec());

        // Test delete()
        System.out.println("After delete Q");
        bst.delete("Q");
        System.out.println("Size: " + bst.size() + " Height: " + bst.height());
        System.out.println("HeightRec: " + bst.heightRec());
        for (String s : bst.keys())
            System.out.println(s + " " + bst.get(s));

        // Test isBST()
        System.out.print("Test isBST: ");
        System.out.println(bst.isBST());
    }    
}
