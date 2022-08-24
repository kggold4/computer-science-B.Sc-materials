
class WordAndDelimiter
{
public:

	virtual void print() const;
	virtual ~WordAndDelimiter();

};

class Word: public WordAndDelimiter
{

public:

	Word(const char* word);
	~Word();
	void print() const;

private:

	char* m_word;

};

class Line
{
public:

	Line();
	Line(const char * line);
	~Line();
	void print() const;
	void add(int newWordNumber,WordAndDelimiter w);
	void del(int newWordNumber,WordAndDelimiter w);

private:

	List m_wordAndDelimiterList;
	int  m_numberOfWordsAndDelimiters;

};

class Page
{
public:

	Page();
	Page(const char *page);
	~Page();
	void print() const;
	void add(int newWordNumber,int lineNumber,WordAndDelimiter w);
	void add(int newLineNumber,Line line);

private:

	char*  strcpy(char* src,int numberOfCharToCopy);

	List m_lineList;	
	int  m_numberOfLines;

};


Page::Page(char *page)
{
	
	int i,j=0;
	char *tmpLine;
	while(1)
	{
		for (i=j;1;i++)
			if( (page[i] == '\n') || (page[i] == '\0) )			
				break;				
		//now j = start of the line ,i = end of the line
		
		if(page[i] == '\0)
		{
			add(m_numberOfLines,Line( &page[j]) );
			return;
		}
	
		tmpLine = strcpy(&page[j],i-j);		
		add(m_numberOfLines, Line(tmpLine) );
		delete []tmpLine;

		j = i;

	}

}

char*  Page::strcpy(char* src,int numberOfCharToCopy)
{
	char *tmp = new char[numberOfCharToCopy+1]; 
	tmp[numberOfCharToCopy] = '\0';

	for(int i=0;i<numberOfCharToCopy;++i)
	
		tmp[i] = src[i];
	
	return tmp;
}
