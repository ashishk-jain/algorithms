package greedy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Element {
	int weight;
	float value;
	float ratio;
	int orgWeight;

	public Element(float value, int weight) {
		this.weight = weight;
		this.orgWeight = weight;
		this.value = value;
		this.ratio = value / weight;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public float getValue() {
		return value;
	}

	public float getRatio() {
		return ratio;
	}
}
public class Knapsack {
	public static void main(String[] args) {
		List<Element> elements = new ArrayList<>();
		elements.add(new Element(1, 1));
		elements.add(new Element(4, 3));
		elements.add(new Element(5, 4));
		elements.add(new Element(7, 5));
		int totalWeights = 7;

		final List<Element> sortedElements = elements.stream().sorted((o1, o2) -> {
			if (o1.getRatio() - o2.getRatio() < 0) {
				return 1;
			} else if (o1.getRatio() - o2.getRatio() > 0) {
				return -1;
			} else {
				return 0;
			}
		}).collect(Collectors.toList());
		List<Element> collectedElements = new ArrayList<>();
		int remainingWeight = totalWeights;
		float totalValue = 0;
		int i = 0;
		for (; i < sortedElements.size(); i++) {
			Element sortedElement = sortedElements.get(i);
			if (remainingWeight >= sortedElement.getWeight()) {
				collectedElements.add(sortedElement);
				totalValue += sortedElement.getValue();
				remainingWeight -= sortedElement.getWeight();
			} else {
				final float value = (sortedElement.getValue() / sortedElement.getWeight()) * remainingWeight;

				totalValue += value;
				final Element updatedElem = new Element(value, remainingWeight);
				updatedElem.setWeight(sortedElement.getWeight());
				collectedElements.add(updatedElem);
				break;
			}
		}
		System.out.println("Total Value: " + totalValue);
		for (Element collectedElement : collectedElements) {
			System.out.printf("Weight %s, Original Weight %s, value %s \n", collectedElement.getWeight(), collectedElement.orgWeight, collectedElement.getValue());
		}
	}
}
