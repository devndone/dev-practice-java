package practice.dev.algo;

public class BstUtil {

    public static BinarySearchTree.BinaryNode<Integer> floor(Integer input,
                                           BinarySearchTree.BinaryNode<Integer> root) {
        if(root == null) {
            return null;
        }
        if(input == root.element) {
            return root;
        }
        if(input < root.element) {
            return floor(input, root.left);
        }
        BinarySearchTree.BinaryNode<Integer> result = floor(input, root.right);
        Integer value = result != null ? result.element : Integer.MAX_VALUE;
        return value <= input ? result : root;
    }

    // Test program
    public static void main( String [ ] args ) {
        BinarySearchTree<Integer> t = new BinarySearchTree<Integer>( );
        t.insert(7);
        t.insert(10);
        t.insert(5);
        t.insert(3);
        t.insert( 6);
        t.insert( 8);
        t.insert( 12);

        final int NUMS = 300;
        final int GAP  =   37;

        System.out.println( "Checking... (no more output means success)" );

//        for( int i = GAP; i != 0; i = ( i + GAP ) % NUMS )
//            t.insert( i );

//        for( int i = GAP; i <= NUMS; i = ( i + GAP ) )
//            t.insert( i );

        //for( int i = 1; i < NUMS; i+= 2 )
        //  t.remove( i );

        //if( NUMS < 40 ) //wrong condition
        t.printTree( );
        System.out.print("\n");
        System.out.println("FindMin is " + t.findMin());
        System.out.println("FindMax is " + t.findMax());

        if( t.findMin( ) != 2 || t.findMax( ) != NUMS - 2 )
            System.out.println( "FindMin or FindMax error!" );

//        for( int i = 2; i < NUMS; i+=2 )
//            if( !t.contains( i ) )
//                System.out.println( "Find error1!" );
        BinarySearchTree.BinaryNode<Integer> result = floor(9, t.getRoot());
        if(result != null) {
            System.out.println("Floor is -> " + result.element);
        } else {
            System.out.println("Floor is -> " + "Not Present");
        }
    }
}
