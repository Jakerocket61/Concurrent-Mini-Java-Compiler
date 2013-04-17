package Symbol;

import java.util.HashMap;
import java.util.Stack;

public class Table<T> {

	public HashMap<String, T> tab;
	public Stack<HashMap<String, T>> scopeStack;

	public Table() {
		scopeStack = new Stack<HashMap<String, T>>();
		tab = new HashMap<String, T>();
		// scopeStack.push(new HashMap<String, T>());
		// this.beginScope();// the first scope
	}

	public void beginScope() {
		scopeStack.push(new HashMap<String, T>());
	}

	public void endScope() {
		scopeStack.pop();
	}

	public T get(String name) {
		T out = null;
		Stack<HashMap<String, T>> temp = new Stack<HashMap<String, T>>();
		while (out == null && !scopeStack.isEmpty()) {
			tab = scopeStack.pop();
			out = tab.get(name);
			temp.push(tab);
		}

		while (!temp.isEmpty()) {
			scopeStack.push(temp.pop());
		}

		/*
		 * if(out == null){ System.err.println("ERROR cannot resolve symbol " +
		 * name); System.exit(0); return out; } else{
		 */
		return out;
		// }
	}

	public T put(String name, T input) {
		if (!scopeStack.empty())
			tab = scopeStack.pop();
		tab.put(name, input);
		scopeStack.push(tab);
		return this.get(name);
	}
}
