public class Palindrome {
    public Deque<Character> wordToDeque(String word){

        Deque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < word.length(); i+=1) {
            Character c = word.charAt(i);
            deque.addLast(c);
        }
        return deque;
    }
    private boolean isPalindromeHelper(Deque <Character> deque) {
        if (deque.size() <= 1) {
            return true;
        }
        else if(deque.removeFirst() == deque.removeLast()) {
            return isPalindromeHelper(deque);
        }
        else
            return false;
    }
    public boolean isPalindrome(String word) {
        return isPalindromeHelper(wordToDeque(word));
    }


    private boolean isPalindromeHelper2(Deque <Character> deque,CharacterComparator cc) {
        if (deque.size() <= 1) {
            return true;
        }
        else if(cc.equalChars(deque.removeFirst(), deque.removeLast())) {
            return isPalindromeHelper2(deque,cc);
        }
        else
            return false;
    }
    public boolean isPalindrome(String word, CharacterComparator cc) {
        return isPalindromeHelper2(wordToDeque(word),cc);
    }
}
