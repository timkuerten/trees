package trees;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class TreeTest {

    Tree<String> tree;

    @Before
    public void setUp() {
        /*
        a   -   b   -   c   -   j
                            -   k
                    -   d   -   f
                    -   e   -   i
                            -   g
                            -   h
            -   z   -   x   -   u
                            -   w
                    -   y   -   q
                            -   r
                            -   s   -   t   -   l
        */
        Tree<String> j = new Tree<>("j");
        Tree<String> k = new Tree<>("k");
        Tree<String> c = new Tree<>("c", Arrays.asList(j, k));
        Tree<String> f = new Tree<>("f");
        Tree<String> d = new Tree<>("d", Arrays.asList(f));
        Tree<String> i = new Tree<>("i");
        Tree<String> g = new Tree<>("g");
        Tree<String> h = new Tree<>("h");
        Tree<String> e = new Tree<>("e", Arrays.asList(i, g, h));
        Tree<String> b = new Tree<>("b", Arrays.asList(c, d, e));
        Tree<String> u = new Tree<>("u");
        Tree<String> w = new Tree<>("w");
        Tree<String> x = new Tree<>("x", Arrays.asList(u ,w));
        Tree<String> l = new Tree<>("l");
        Tree<String> t = new Tree<>("t", Arrays.asList(k));
        Tree<String> s = new Tree<>("s", Arrays.asList(t));
        Tree<String> q = new Tree<>("q");
        Tree<String> r = new Tree<>("r");
        Tree<String> y = new Tree<>("y", Arrays.asList(q, r, s));
        Tree<String> z = new Tree<>("z", Arrays.asList(x ,y));
        tree = new Tree<>("a", Arrays.asList(b, z));
    }

    @Test
    public void test() {
        System.out.println(tree);
    }

}
