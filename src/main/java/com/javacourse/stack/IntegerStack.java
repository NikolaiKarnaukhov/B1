package com.javacourse.stack;


public class IntegerStack {

	/**
	 * Добавляет новый элемент в стек, учтите следующее при реализации:
	 * 1) каждый следующий вызов добавляет новый элемент на верх стека.
	 * 2) реализация должна позволять добавлять null-value элементы в стек.
	 *
	 * @param item добавляемый целочисленный элемент
	 */
	public void push(Integer item) {
		// TODO: замените тело метода на полноценную реализацию
		throw new RuntimeException("Method not implemented");
	}

	/**
	 * Извлекает из стека последний добавленный элемент, при реализации учтите что:
	 * 1) элементы стека извлекаются методом `pop` в порядке обратном порядку добавления их туда.
	 * 2) после вызова этого метода в стеке становится на один элемент меньше.
	 * 3) если в стеке нет элементов, то вызов этого метода приводит к броску исключения
	 * типа RuntimeException с текстом сообщения "Empty Stack Exception".
	 *
	 * @return значение элемента который был извлечен из стека
	 */
	public Integer pop() {
		// TODO: замените тело метода на полноценную реализацию
		throw new RuntimeException("Method not implemented");
	}

	/**
	 * Вызов этого метода дает возможность посмотреть значение на верхушке стека,
	 * не извлекая элемент из него. При реализации учтите следующие моменты:
	 * 1) вызов метода peek не должен влиять на порядок элементов стека и его состояние
	 * 2) если peek вызван на пустом стеке, то это приводит к броску исключения
	 * типа RuntimeException с текстом сообщения "Empty Stack Exception"
	 * 3) peek может вернуть `null` если до этого на вершину стека был помещен
	 * элемент со значением `null`.
	 *
	 * @return значение элемента на вершине стека
	 */
	public Integer peek() {
		// TODO: замените тело метода на полноценную реализацию
		throw new RuntimeException("Method not implemented");
	}
}
