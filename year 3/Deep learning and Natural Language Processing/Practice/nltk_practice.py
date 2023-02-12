import nltk
from nltk.stem.porter import PorterStemmer
from nltk.stem.lancaster import LancasterStemmer
from nltk.stem import SnowballStemmer


if __name__ == '__main__':

    # Tokenization
    # nltk.download('punkt')
    print("TOKENIZATION")
    my_text = "Where is St. Paul located? I don't seem to find it. It isn't in my map."
    print(f"Text: '{my_text}'")
    print(f"Split: {my_text.split(' ')}")
    print(f"Word Tokenize: {nltk.word_tokenize(my_text)}")
    print(f"Sentence Tokenize:\n{nltk.sent_tokenize(my_text)}")
    print("\n")

    # Stemming
    print("STEMMING")
    my_text = "Whoever eats many cookies is regretting doing so"
    print(f"Text: '{my_text}'")
    ps = PorterStemmer()
    stemmed_sentence = []
    for word in nltk.word_tokenize(my_text):
        stemmed_sentence.append(ps.stem(word=word))
    print(f"Stemmed Sentence: {stemmed_sentence}")
    print("\n")

    # POS
    print("Part of Speech")
    print(f"Text: '{my_text}'")
    # nltk.download('averaged_perceptron_tagger')
    my_tokenized_text = nltk.word_tokenize(my_text)
    print(f"Pos tag: {nltk.pos_tag(my_tokenized_text)}")

