package other

import org.junit.Assert.assertTrue
import org.junit.Test

class PalindromeTest {

    @Test
    fun testPalindromePortuguesePhrase() {
        val text = "A mãe te ama"
        assertTrue(isPalindrome(text))
    }

    @Test
    fun testPalindromeEnglishPhrase() {
        val text = "Mr Owl ate my metal worm"
        assertTrue(isPalindrome(text))
    }

    @Test
    fun testPalindromeName() {
        val text = "Hannah"
        assertTrue(isPalindrome(text))
    }

    @Test
    fun testPalindromeNumber() {
        val text = "2002"
        assertTrue(isPalindrome(text))
    }

    private fun isPalindrome(text: String): Boolean {
        // 1. Normalize the string to separate characters from their accents/diacritics
        val normalized = Normalizer.normalize(text, Normalizer.Form.NFD)
        
        // 2. Remove the accents using a Regular Expression
        val withoutAccents = "\\p{InCombiningDiacriticalMarks}+".toRegex().replace(normalized, "")
        
        // 3. Keep only alphanumeric characters and convert to lowercase
        val cleanText = withoutAccents.replace("[^A-Za-z0-9]".toRegex(), "").lowercase()
        
        // 4. Check if the cleaned string is equal to its reversed self
        return cleanText == cleanText.reversed()
    }
}
