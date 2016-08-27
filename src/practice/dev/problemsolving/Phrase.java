package practice.dev.problemsolving;

public class Phrase implements Comparable<Phrase> {

	private final String phrase;
	private Integer count;
	
	public Phrase(String phrase, Integer count) {
		this.phrase = phrase;
		this.count = count;
	}
	
	public Phrase(String phrase) {
		this(phrase, 1);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((phrase == null) ? 0 : phrase.hashCode());
		return result;
	}

	//TODO : Need correction to get right results for Phrases i.e.strings with more words and compared word by word
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Phrase other = (Phrase) obj;
		if (phrase == null) {
			if (other.phrase != null)
				return false;
		} else if (!phrase.equals(other.phrase))
			return false;
		return true;
	}

	public void incrementCount() {
		this.count++;
	}

	public void decrementCount() {
		this.count--;
		this.validateCount();
	}

	public void incrementCountBy(Integer count) {
		this.count += count;
	}

	public void decrementCountBy(Integer count) {
		this.count -= count;
		this.validateCount();
	}
	
	private void validateCount() {
		if(this.count <= 0) {
			this.count = 1;
		}
	}
	
	protected int flipCompare(boolean flag, Phrase o) {
		return (
				flag ? o.getCount().compareTo(this.count) : this.count.compareTo(o.getCount())
			);
	}
	
	@Override
	public int compareTo(Phrase o) {
		return this.flipCompare(true, o);
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getPhrase() {
		return phrase;
	}
	
	@Override
	public String toString() {
		return this.phrase;
	}

}
