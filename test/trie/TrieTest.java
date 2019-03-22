package trie;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TrieTest {
    private static final String[] WORDS = {"she", "sells", "sea", "shore",
            "know", "knowledge", "knowledges", "knowledgement"};
    private Trie t = new Trie();

    @Before
    public void setup() {
        for (String word : WORDS) {
            t.insert(word);
        }
    }

    @Test
    public void deleteOne() {
        Assert.assertTrue(t.delete("she"));
        Assert.assertEquals(3, t.startsWith("s"));
        Assert.assertEquals(4, t.startsWith("k"));
        Assert.assertEquals(1, t.startsWith("sh"));
        Assert.assertEquals(0, t.startsWith("she"));
        Assert.assertFalse(t.search("she"));
        Assert.assertTrue(t.search("know"));
    }

    @Test
    public void deleteTwo() {
        Assert.assertTrue(t.delete("she"));
        Assert.assertTrue(t.delete("shore"));
        Assert.assertEquals(2, t.startsWith("s"));
        Assert.assertEquals(4, t.startsWith("k"));
        Assert.assertEquals(0, t.startsWith("sh"));
        Assert.assertEquals(0, t.startsWith("she"));
        Assert.assertFalse(t.search("shore"));
    }

    @Test
    public void deleteAllSWords() {
        Assert.assertTrue(t.delete("she"));
        Assert.assertTrue(t.delete("shore"));
        Assert.assertTrue(t.delete("sells"));
        Assert.assertTrue(t.delete("sea"));
        Assert.assertEquals(0, t.startsWith("s"));
        Assert.assertEquals(4, t.startsWith("k"));
        Assert.assertEquals(0, t.startsWith("sh"));
        Assert.assertEquals(0, t.startsWith("she"));
        Assert.assertFalse(t.search("shore"));
    }

    @Test
    public void deleteAll() {
        for (String word : WORDS) {
            t.delete(word);
        }
        Assert.assertEquals(0, t.startsWith("s"));
        Assert.assertEquals(0, t.startsWith("k"));
        Assert.assertEquals(0, t.startsWith("sh"));
        Assert.assertEquals(0, t.startsWith("she"));
        Assert.assertFalse(t.search("know"));
    }

    @Test
    public void deleteAllInsertOne() {
        for (String word : WORDS) {
            t.delete(word);
        }
        t.insert("new");
        Assert.assertEquals(0, t.startsWith("s"));
        Assert.assertEquals(0, t.startsWith("k"));
        Assert.assertEquals(1, t.startsWith("n"));
        Assert.assertTrue(t.search("new"));
    }
}