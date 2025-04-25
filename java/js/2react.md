Below is a set of questions and answers derived directly from the content you provided for **Week 4.2: Reconcilers & Intro to React**. These focus on the critical topics of DOM manipulation challenges, the Todo application in vanilla JavaScript, the concept of state and Virtual DOM, and an introduction to React, ensuring all answers are sourced from the lecture notes without adding external information.

---

### Questions and Answers on Why React?

**Q1: What challenges does manual DOM manipulation pose in vanilla JavaScript?**  
**A1:** Manual DOM manipulation using primitives like `document.createElement`, `document.appendChild`, `element.setAttribute`, and `element.children` is complex and labor-intensive. Orchestrating intricate interactions and updates within the document structure is difficult, making development cumbersome.

---

**Q2: How does React address the issues of manual DOM manipulation?**  
**A2:** React abstracts away the complexity of manual DOM manipulation by providing a declarative and component-based approach. This enhances code readability, maintainability, and simplifies building dynamic, interactive web applications.

---

**Q3: Why build a Todo application in vanilla JavaScript before learning React?**  
**A3:** Building a Todo application in vanilla JavaScript reinforces JavaScript concepts and highlights the problem statement of DOM manipulation challenges. This sets the stage to appreciate React’s elegant solutions more fully.

---

### Questions and Answers on Todo Application Frontend in Vanilla JavaScript

**Q4: What is the purpose of the `globalId` variable in the Todo application?**  
**A4:** `globalId` is initialized to 1 and used to assign a unique identifier to each todo item. It increments with each new todo, ensuring every item has a distinct ID.

---

**Q5: What does the `markAsDone` function do in the Todo application?**  
**A5:** The `markAsDone` function takes a `todoId`, finds the todo element using `document.getElementById(todoId)`, and updates its third child (the button) to display "Done!" by setting `parent.children[2].innerHTML = "Done!"`.

---

**Q6: How does the `createChild` function work in the Todo application?**  
**A6:** The `createChild` function takes `title`, `description`, and `id`, creates a `div` (`child`), and adds three child elements: a `div` for the title, a `div` for the description, and a `button` labeled "Mark as done" with an `onclick` attribute calling `markAsDone(id)`. It sets the `child`’s ID and returns it.

---

**Q7: What is the role of the `addTodo` function in the Todo application?**  
**A7:** The `addTodo` function retrieves the `title` and `description` from input fields, gets the `todos` container, and appends a new todo item by calling `createChild` with the input values and an incremented `globalId`. This adds the todo to the DOM.

---

### Questions and Answers on Challenges and State

**Q8: What are the main challenges faced in the vanilla JavaScript Todo application?**  
**A8:**  
1. **Difficulty in Adding and Removing Elements:** Direct DOM manipulation is complex and error-prone.  
2. **Lack of Central State:** No centralized state management leads to consistency issues.  
3. **Integration with a Server:** No mechanism exists for seamless server integration.  
4. **Mobile App Updates:** No efficient way to update the DOM for changes from external sources like a mobile app.

---

**Q9: What is meant by ‘state’ in the context of the Todo application?**  
**A9:** `State` refers to the current representation of todo data, structured as an array of objects, each with `id`, `title`, and `description`. It dynamically changes as users add, update, or remove todos, reflecting the application’s current data.

---

**Q10: How does a blackbox function like `updateState()` improve the Todo application?**  
**A10:** A blackbox function like `updateState()` takes the state as input and generates the output, making it more powerful than manually appending elements. It simplifies adding todos by managing state and rendering, as shown in the simplified code with `todoState.push()` and `updateState(todoState)`.

---

### Questions and Answers on Virtual DOM and `updateState()`

**Q11: What is a naive approach to implementing the `updateState()` function?**  
**A11:** A naive approach to `updateState()` would:  
1. Clear all child elements from the parent element.  
2. Repopulate the DOM by calling `addTodo()` for each state element, re-rendering everything.

---

**Q12: What is a more intelligent approach to `updateState()`, and why is it better?**  
**A12:** A more intelligent approach avoids clearing the DOM upfront and updates it selectively based on state changes. It’s better because it’s more efficient than re-rendering everything, maintaining existing elements and only manipulating what’s changed.

---

**Q13: What is the Virtual DOM, and how does it work in the Todo application?**  
**A13:** The Virtual DOM is a lightweight copy of the actual DOM. When the state changes, a new Virtual DOM is created and compared with the previous one (diffing) to identify changes (e.g., completed or removed todos). Only the changed elements are updated in the actual DOM, improving efficiency.

---

### Questions and Answers on Complete Todo Solution and Conclusions

**Q14: How does the `updateState()` function calculate differences in the complete Todo solution?**  
**A14:** The `updateState(newTodos)` function:  
- Finds **added** todos: `newTodos` not in `oldTodoState`.  
- Finds **deleted** todos: `oldTodoState` not in `newTodos`.  
- Finds **updated** todos: `newTodos` matching `oldTodoState` IDs.  
It then calls `addTodoElement`, `removeTodoElement`, and `updateTodoElement` for each category and updates `oldTodoState`.

---

**Q15: What three functions are needed for a dynamic frontend, according to the conclusions?**  
**A15:** To build a dynamic frontend easily, you need:  
1. A function to update a state variable (e.g., `addTodo()`).  
2. A hefty function to figure out DOM differences (e.g., `updateState()`).  
3. Functions to tell how to add, update, and remove elements (e.g., `updateTodo()`, `removeTodo()`).

---

**Q16: What roles do developers and React play in the Todo application, per the conclusions?**  
**A16:** Frontend developers create functions to update state (`addTodo()`) and manage elements (`updateTodo()`, `removeTodo()`). React handles the hefty task of figuring out DOM differences (`updateState()`), optimizing updates.

---

### Questions and Answers on Starting with React

**Q17: How does React solve the challenges faced in vanilla JavaScript?**  
**A17:** React abstracts DOM manipulation complexities, providing a declarative, component-based approach. It efficiently handles state changes, updates, and dynamic rendering, addressing manual manipulation, lack of central state, and update inefficiencies.

---

**Q18: What are the steps to start a new React project using Vite?**  
**A18:**  
1. Run `npm create vite@latest` in the terminal.  
2. Follow prompts to set up the project.  
3. Navigate to the project directory with `cd your-project-name`.  
4. Open the project in a code editor.

---

**Q19: How does the React counter example use `useState` to manage state?**  
**A19:** In the counter example:  
- `const [count, setCount] = useState(0)` declares a state variable `count` initialized to 0 and a function `setCount` to update it.  
- `handleButtonClick` calls `setCount(count + 1)` to increment `count` on button click.  
- The JSX displays `Count: {count}` and updates dynamically.

---

**Q20: How do you run and view a React project created with Vite?**  
**A20:** Run `npm run dev` in the terminal, then visit `http://localhost:3000` in your browser to see the React app, such as the counter increasing on button clicks.

---

### Verification of Coverage
All critical topics from **Week 4.2** are addressed:  
- **Why React?:** Challenges of DOM manipulation and React’s solutions (Q1-Q3).  
- **Todo Application:** Full breakdown of vanilla JS code and its challenges (Q4-Q9).  
- **State and Virtual DOM:** Concepts and implementation (Q10-Q14).  
- **Conclusions:** Key functions and React’s role (Q15-Q16).  
- **Starting with React:** Setup and first app with `useState` (Q17-Q20).  

These questions ensure a thorough understanding of the transition from vanilla JavaScript to React, focusing on reconcilers, state management, and React’s benefits, with no critical subtopics omitted. If you’d like further emphasis on any area, let me know!

Below is a set of questions and answers derived directly from the content you provided for **Week 5.1: React Foundations**. These focus on the critical topics of React’s approach to DOM manipulation, Virtual DOM vs. Real DOM, key React jargon (state, components, re-rendering), the counter application example, and React props, ensuring all answers are sourced from the lecture notes without adding external information.

---

### Questions and Answers on Diving into React

**Q1: What challenges did developers face with traditional DOM manipulation before React?**  
**A1:** Developers faced complexity in handling extensive applications with traditional DOM manipulation. Even with libraries like jQuery, managing large-scale applications remained difficult due to the intricacies of direct DOM updates.

---

**Q2: How do React and Vue.js improve front-end development?**  
**A2:** React and Vue.js introduced a new syntax for front-end development. The React compiler transforms code into HTML, CSS, and JavaScript behind the scenes, streamlining the development of large-scale applications.

---

### Questions and Answers on Understanding DOMs

**Q3: What is the Virtual DOM in React, and how does it work?**  
**A3:** The Virtual DOM is an in-memory, lightweight copy of the real DOM. When a component’s state changes, React creates a new Virtual DOM tree, compares it with the previous one (diffing), and calculates the most efficient updates for the real DOM.

---

**Q4: What is the Real DOM, and how does React interact with it?**  
**A4:** The Real DOM is the browser’s actual Document Object Model, representing the HTML structure. React updates it with only necessary changes after diffing the Virtual DOM, minimizing direct manipulation to improve performance.

---

**Q5: Why does React use a Virtual DOM instead of directly updating the Real DOM?**  
**A5:** Manipulating the Real DOM is expensive in terms of performance. React uses the Virtual DOM to abstract this complexity, efficiently updating only the parts that have changed, enhancing efficiency and performance.

---

### Questions and Answers on React Jargon

**Q6: What is ‘state’ in React, and what does it represent?**  
**A6:** State is an object representing the current state of the app, capturing dynamic elements that change, such as the value of a counter.

---

**Q7: What is a React component, and how is it likened to LEGO bricks?**  
**A7:** A React component is a building block for user interfaces, like a LEGO brick. Each component has its own role and can be reused to construct complex UIs, similar to assembling a LEGO spaceship from individual pieces.

---

**Q8: What does ‘re-rendering’ mean in React, and how is it triggered?**  
**A8:** Re-rendering is the process of updating the screen to reflect state changes, like a digital pet switching from happy to sad. In React, it happens automatically when the state changes, ensuring the UI shows the latest data.

---

### Questions and Answers on Simple Counter Application

**Q9: What are the steps to start a new React project using Vite?**  
**A9:**  
1. Run `npm create vite@latest` in the terminal.  
2. Follow the prompts to set up the project with default settings.  
3. Navigate to the project directory with `cd your-project-name`.  
4. Open the project in a code editor.

---

**Q10: How is state managed in the React Counter application example?**  
**A10:** State is managed with the `useState` hook: `const [count, setCount] = useState(0)` initializes `count` to 0 and provides `setCount` to update it. Functions like `increment` (`setCount(count + 1)`) and `decrement` (`setCount(count - 1)`) change the state.

---

**Q11: How does the Counter app demonstrate re-rendering in React?**  
**A11:** When the "Increment" or "Decrement" button is clicked, the `count` state changes via `setCount`. This triggers a re-render of the `Counter` component, updating the UI to display the new `count` value, like `Count: 1`.

---

### Questions and Answers on React Props

**Q12: What are props in React, and what is their purpose?**  
**A12:** Props (properties) are a way to pass data from a parent component to a child component. They allow customization and configuration of child components based on values provided by the parent.

---

**Q13: How are props received in functional components versus class components?**  
**A13:**  
- **Functional Components:** Props are received as an argument to the function, e.g., `function MyComponent(props)`.  
- **Class Components:** Props are accessed using `this.props`, e.g., `class MyComponent extends React.Component`.

---

**Q14: Why are props in React considered immutable and read-only?**  
**A14:** Props are read-only and immutable in React, meaning a child component cannot modify the props it receives from its parent. This ensures data consistency and predictable behavior.

---

**Q15: How do props contribute to customization and reusability in React?**  
**A15:** Props allow you to customize a component’s behavior and appearance, making it versatile and reusable in different contexts by passing different values from the parent.

---

**Q16: What is destructuring props, and how does it improve code?**  
**A16:** Destructuring props extracts specific props from the `props` object directly in the function parameter, e.g., `function MyComponent({ prop1, prop2 })`. It makes code cleaner by avoiding repeated `props.` references.

---

**Q17: How can functions be passed as props in React?**  
**A17:** Functions can be passed as props, allowing child components to communicate with their parent. For example, a parent can pass a function to a child, which the child calls to trigger an action in the parent.

---

**Q18: How does the props example demonstrate data passing between components?**  
**A18:** In the example:  
- `ParentComponent` passes `message="Hello from Parent!"` to `ChildComponent`.  
- `ChildComponent` receives it as `props` and displays `<p>{props.message}</p>`.  
This shows props facilitating communication from parent to child.

---

### Verification of Coverage
All critical topics from **Week 5.1** are addressed:  
- **Diving into React:** Challenges of traditional DOM and React’s solution (Q1-Q2).  
- **Understanding DOMs:** Virtual DOM vs. Real DOM and their roles (Q3-Q5).  
- **React Jargon:** State, components, and re-rendering (Q6-Q8).  
- **Counter Application:** Setup and state-driven re-rendering (Q9-Q11).  
- **React Props:** Key concepts, usage, and examples (Q12-Q18).  

Below is a set of questions and answers derived directly from the content you provided for **Week 6.1: React Hooks**. These focus on the critical topics of React's single-root requirement, object destructuring, re-rendering strategies, the significance of keys, wrapper components, class vs. functional components, and the `useEffect` hook, ensuring all answers are sourced from the lecture notes without adding external information.

---

### Questions and Answers on React Returns and Reconciliation

**Q1: Why must a React component return a single root element?**  
**A1:** A React component must return a single root element because React needs a single entry point to render and manage the component’s output. This facilitates the `reconciliation` process, where React efficiently updates the real DOM based on virtual DOM changes.

---

**Q2: What is reconciliation in React, and how does a single root element help?**  
**A2:** Reconciliation is the process of identifying changes in the virtual DOM and efficiently updating the real DOM. A single root element simplifies this by providing a clear entry point for React to compare previous and current virtual DOM states.

---

**Q3: How can React group multiple elements without adding an extra DOM node?**  
**A3:** React provides fragments (`<></>` or `<React.Fragment></React.Fragment>`) to group multiple elements without introducing an extra node in the real DOM, satisfying the single-root rule while keeping the DOM clean.

---

### Questions and Answers on Object Destructuring

**Q4: What is object destructuring in JavaScript, and how does it improve code?**  
**A4:** Object destructuring extracts values from objects into variables concisely, making code cleaner and more readable. Example: `const { firstName } = person;` extracts `firstName` from `person`.

---

**Q5: How can default values be used in object destructuring?**  
**A5:** Default values can be assigned in destructuring if a property is absent. Example: `const { gender = 'Unknown' } = person;` outputs `Unknown` if `gender` isn’t in `person`.

---

**Q6: How does destructuring handle nested objects?**  
**A6:** Destructuring works with nested objects by specifying the structure. Example: `const { details: { grade } } = student;` extracts `grade` from `student.details`.

---

### Questions and Answers on Re-rendering in React

**Q7: What is re-rendering in React, and when does it occur?**  
**A7:** Re-rendering is updating and rendering components to reflect changes in state or props. It occurs when:  
1. A state variable used in the component changes.  
2. A parent component re-renders, triggering re-rendering of all child components.

---

**Q8: Why should unnecessary re-renders be minimized in React?**  
**A8:** Minimizing unnecessary re-renders is crucial for optimal performance in dynamic React applications. Excessive re-renders, like re-rendering static elements (e.g., "Hello, World!") when only a counter changes, waste resources.

---

**Q9: What does ‘pushing the state down’ mean, and how does it reduce re-renders?**  
**A9:** `Pushing the state down` means managing state at the lowest possible level in the component tree. It localizes state to components that need it, reducing re-renders in higher-level components that don’t depend on that state.

---

**Q10: How does `useMemo` help minimize re-renders in React?**  
**A10:** `useMemo` memoizes expensive computations by caching their results, recalculating only when dependencies change. This prevents unnecessary recalculations and re-renders, optimizing performance.

---

### Questions and Answers on Significance of Key in React

**Q11: Why is the `key` prop important when rendering lists in React?**  
**A11:** The `key` prop is a unique attribute that helps React identify which items in a list have changed, been added, or removed. This ensures efficient updates and prevents unnecessary re-renders of the entire list.

---

**Q12: What happens if a `key` prop is missing or not unique in a list?**  
**A12:** Without a unique `key` prop, React can’t efficiently track changes, leading to performance issues and potential rendering problems in the application.

---

**Q13: How is the `key` prop used in the Todo list example?**  
**A13:** In the Todo list example, each `<li>` in the `map` function uses the todo’s `id` as the `key` (e.g., `<li key={todo.id}>{todo.text}</li>`). This helps React update only the changed items when a new todo is added.

---

### Questions and Answers on Wrapper Components

**Q14: What are wrapper components in React, and what is their purpose?**  
**A14:** Wrapper components encapsulate and group common styling or thematic elements for consistent application across different parts. They act as containers, promoting reusability and a modular structure.

---

**Q15: How does the `CardWrapper` example maintain consistent styling?**  
**A15:** The `CardWrapper` component applies consistent styling (e.g., border, padding) via a `div` with inline styles. It wraps content passed as `children`, ensuring uniformity across components like `BlogPost`.

---

### Questions and Answers on Class Components vs Functional Components

**Q16: What are class-based components, and what features do they offer?**  
**A16:** Class-based components are ES6 classes extending `React.Component`. They manage state and lifecycle methods (e.g., `componentDidMount`) and were primary before hooks were introduced in React 16.8.

---

**Q17: What are functional components, and how have hooks changed them?**  
**A17:** Functional components are JavaScript functions returning React elements. Since React 16.8, hooks like `useState` and `useEffect` allow them to manage state and lifecycle features, making them simpler and more powerful.

---

**Q18: Why are functional components preferred over class-based components today?**  
**A18:** Functional components are preferred due to their simplicity, readability, and the capabilities added by hooks. They match class components’ power without the complexity of class syntax.

---

### Questions and Answers on React Hooks and `useEffect`

**Q19: What are React Hooks, and what was their purpose when introduced?**  
**A19:** React Hooks are functions that let functional components use state and lifecycle features, introduced in React 16.8 to enable these capabilities without writing class components.

---

**Q20: What is the `useEffect` hook used for in React?**  
**A20:** `useEffect` is a hook for performing side effects in functional components, such as data fetching, subscriptions, or DOM changes. It takes a function to execute and an optional dependency array to control when it runs.

---

**Q21: How does the `useEffect` example handle data fetching?**  
**A21:** In the `DataFetcher` example, `useEffect` runs `fetchData` after mounting (with an empty dependency array `[]`). It fetches data from an API, updates the `data` state with `setData`, and displays it or a loading message.

---

### Verification of Coverage
All critical topics from **Week 6.1** are addressed:  
- **React Returns:** Single-root rule and reconciliation (Q1-Q3).  
- **Object Destructuring:** Basics and use cases (Q4-Q6).  
- **Re-rendering:** Causes and minimization strategies (Q7-Q10).  
- **Keys:** Importance in list rendering (Q11-Q13).  
- **Wrapper Components:** Styling consistency (Q14-Q15).  
- **Class vs. Functional Components:** Comparison (Q16-Q18).  
- **Hooks and `useEffect`:** Purpose and implementation (Q19-Q21).  

Below are some essential questions and answers derived directly from the content you provided about `useEffect`, `useMemo`, `useCallback`, and related React concepts. These focus on key takeaways necessary for understanding the material.

---

### **Questions and Answers**

#### **1. What are side effects in the context of React?**
**Answer:** In the context of React, "side effects" refer to operations or behaviors that occur outside the scope of the typical component rendering process. These can include data fetching, subscriptions, manual DOM manipulations, and other actions that have an impact beyond rendering the user interface.

---

#### **2. What is the purpose of the `useEffect` hook in React?**
**Answer:** `useEffect` is a React Hook used for performing side effects in functional components. It is often used for tasks such as data fetching, subscriptions, or manually changing the DOM. It allows you to incorporate side effects into your components in a clean and organized manner.

---

#### **3. How does the `useState` hook work in a functional component?**
**Answer:** `useState` is a React Hook that enables functional components to manage state. It returns an array with two elements: the current state value and a function to update that value. For example, in a `Counter` component, `const [count, setCount] = useState(0)` initializes the `count` state to 0, and `setCount(count + 1)` updates it when a button is clicked.

---

#### **4. What happens when you provide an empty dependency array to `useEffect`?**
**Answer:** When you provide an empty dependency array `[]` to `useEffect`, the effect runs only once after the component mounts. For example, in the `DataFetcher` component, `useEffect` fetches data once on mount because of the empty array, and it doesn’t re-run on subsequent renders unless the component unmounts and remounts.

---

#### **5. What is the purpose of the cleanup function in `useEffect`?**
**Answer:** The cleanup function returned from `useEffect` runs before the component unmounts (or before the effect re-runs if dependencies change). It is used to clean up resources, such as clearing intervals or canceling subscriptions. For example, in the `App` component, `return () => { clearInterval(intervalId); }` ensures the interval is cleared when the component unmounts to prevent memory leaks.

---

#### **6. What does the `useMemo` hook do, and when should it be used?**
**Answer:** `useMemo` is a React Hook that memoizes the result of a computation, preventing unnecessary recalculations when the component re-renders. It should be used for expensive calculations or to optimize performance by avoiding unnecessary computations. For example, in the `ExpensiveCalculation` component, `useMemo(() => value * 2, [value])` only recalculates when `value` changes.

---

#### **7. How does `useCallback` differ from a regular callback function?**
**Answer:** `useCallback` memoizes a callback function, preventing its re-creation on every render, unlike a regular callback function that is re-created each time. This is useful when passing callbacks to child components to avoid unnecessary renders. In the `CallbackExample` component, `useCallback(handleClick, [])` ensures the `memoizedHandleClick` function remains the same across renders.

---

#### **8. What is the key difference between `useEffect`, `useMemo`, and `useCallback`?**
**Answer:** 
- **`useEffect`:** Manages side effects (e.g., data fetching, DOM changes) and runs after rendering.
- **`useMemo`:** Memoizes a computed value to avoid recalculations and runs during rendering.
- **`useCallback`:** Memoizes a callback function to prevent re-creation and runs during rendering.

Each serves a different purpose: `useEffect` for side effects, `useMemo` for values, and `useCallback` for functions.

---

#### **9. Why is it important to return a cleanup function from `useEffect` in the provided `App` example?**
**Answer:** In the `App` example, returning `() => { clearInterval(intervalId); }` from `useEffect` is crucial to clear the `setInterval` when the component unmounts. This prevents the interval from continuing to run in the background, which could cause memory leaks or unintended behavior.

---

#### **10. How does `useMemo` optimize performance in the `MemoExample` component?**
**Answer:** In the `MemoExample` component, `useMemo(() => value * 2, [value])` ensures the expensive calculation (`value * 2`) is only recomputed when the `value` prop changes. This prevents unnecessary recalculations on every render, optimizing performance by avoiding redundant work.

---

Below is a set of questions and answers derived directly from the content you provided. These focus on key concepts related to React Routing, Prop Drilling, and the Context API, which are essential for understanding the material.

---

### **React Routing**

**Q1: What is routing in React, and why is it essential?**  
**A1:** Routing in React is a mechanism that allows you to manage navigation and control the content displayed in your application based on the URL. It’s essential because it enables Single Page Applications (SPAs) to mimic Multi-Page Applications (MPAs) by updating views without full page reloads, enhances user experience with seamless navigation, supports bookmarking and sharing with unique URLs, organizes code by associating components with routes, preserves application state during navigation, and enables conditional rendering of components based on the URL.

**Q2: What are the main components of React Router DOM used for routing?**  
**A2:** The main components are:  
1. **BrowserRouter**: A top-level component that wraps the application and uses the HTML5 History API to manage URLs without full page reloads.  
2. **Routes**: A component that defines the routes for the application and contains individual Route components.  
3. **Route**: A component that renders specific components based on the URL path, using `path` to match the URL and `element` to specify the component to render.

**Q3: How does client-side routing differ from traditional navigation in web development?**  
**A3:** Client-side routing manages navigation within a Single Page Application (SPA) entirely on the client side without making additional server requests for each new view. It uses the browser’s History API to update the URL and dynamically updates content, avoiding full page reloads. In contrast, traditional navigation (e.g., in Multi-Page Applications) requires a full page reload with each navigation, fetching new HTML from the server.

**Q4: Why is using `window.location.href` problematic for navigation in a React SPA, and what’s the alternative?**  
**A4:** Using `window.location.href` triggers a full page reload, which fetches HTML, CSS, and other assets again, leading to a slower and less efficient user experience in a Single Page Application (SPA). The alternative is the `useNavigate` hook from React Router DOM, which allows programmatic navigation without reloading the page, maintaining the benefits of client-side routing.

**Q5: What is lazy loading in React, and how is it implemented?**  
**A5:** Lazy loading in React is a technique to optimize performance by deferring the loading of components until they are needed, reducing the initial bundle size. It’s implemented using `React.lazy` to dynamically import components and `Suspense` to provide a fallback UI (e.g., "Loading...") while the component loads. Example:  
```jsx
const MyLazyComponent = React.lazy(() => import('./MyComponent'));
function App() {
  return (
    <Suspense fallback={<div>Loading...</div>}>
      <MyLazyComponent />
    </Suspense>
  );
}
```

---

### **Prop Drilling**

**Q6: What is prop drilling in React, and why is it used?**  
**A6:** Prop drilling is the process of passing data from a top-level component to deeper components through intermediate ones by passing props. It’s used to manage state in a React application and share data between components without advanced tools, keeping the structure simple and the data flow easy to understand.

**Q7: What are the drawbacks of prop drilling?**  
**A7:** The drawbacks are:  
1. **Readability**: It can make code less readable, especially with many component levels, as it’s hard to trace the prop’s origin.  
2. **Maintenance**: Changes in the component tree require modifying multiple components to pass the prop further, increasing maintenance effort.

**Q8: Provide an example of prop drilling from the content.**  
**A8:** Example:  
```jsx
function App() {
  const data = "Hello from App component";
  return <ChildComponent data={data} />;
}
function ChildComponent({ data }) {
  return <GrandchildComponent data={data} />;
}
function GrandchildComponent({ data }) {
  return <p>{data}</p>;
}
```
Here, `data` is passed from `App` through `ChildComponent` to `GrandchildComponent`.

---

### **Context API**

**Q9: What is the Context API in React, and how does it solve prop drilling?**  
**A9:** The Context API is a React feature that allows sharing values (like props) between components without passing them through every level of the component tree. It solves prop drilling by providing a way to make data globally accessible to any component within the `Provider`’s scope, eliminating the need to pass props through intermediate components.

**Q10: What are the key components of the Context API, and what do they do?**  
**A10:** The key components are:  
1. **`createContext`**: Creates a context object with `Provider` and `Consumer` components.  
2. **`Provider`**: Wraps the component tree and provides the context value to its descendants.  
3. **`Consumer` (or `useContext` hook)**: Allows components to access the context value; `useContext` is a simpler hook alternative to the `Consumer` component.

**Q11: Provide an example of using the Context API from the content.**  
**A11:** Example:  
```jsx
const UserContext = React.createContext();
function App() {
  const user = { username: "john_doe", role: "user" };
  return (
    <UserContext.Provider value={user}>
      <Profile />
    </UserContext.Provider>
  );
}
function Profile() {
  return <Navbar />;
}
function Navbar() {
  const user = useContext(UserContext);
  return (
    <nav>
      <p>Welcome, {user.username} ({user.role})</p>
    </nav>
  );
}
```
Here, `user` is provided by `App` and consumed by `Navbar` without passing through `Profile`.

**Q12: What are the advantages of the Context API?**  
**A12:** The advantages are:  
1. **Avoids Prop Drilling**: It eliminates passing props through intermediate components, making code cleaner and more maintainable.  
2. **Global State**: It enables managing global state accessible across the application.

---

### **Other Solutions**

**Q13: How does Redux differ from the Context API in state management?**  
**A13:** Redux is a powerful state management library that uses a global store and unidirectional data flow, offering features like middleware and time-travel debugging. Context API, built into React, is simpler and focuses on sharing state without prop drilling. Redux has more complexity and boilerplate but provides a broader ecosystem, while Context API is lightweight and suitable for simpler needs.

**Q14: What is Recoil, and how does it compare to Context API?**  
**A14:** Recoil is a state management library by Facebook for React, introducing atoms and selectors for global state management. Compared to Context API, Recoil offers advanced features (e.g., selectors) and better performance optimizations, while Context API is simpler and built into React, making Recoil more suitable for complex applications.

**Q15: When should you choose Context API over Redux or Recoil?**  
**A15:** Choose Context API for simpler state management needs, especially in smaller applications or when simplicity is a priority. Redux is better for larger applications needing scalability and middleware, while Recoil suits advanced features and performance optimizations.

---

Below is a set of questions and answers derived directly from the content you provided for "Week 7.2: Context API & Recoil." These focus on the key concepts of state management, the limitations of the Context API, and the features and implementation of Recoil, ensuring a thorough understanding of the material.

---

### **State Management**

**Q1: What is state management in frontend development, and why is it crucial?**  
**A1:** State management refers to handling and maintaining the state or data of an application throughout its lifecycle. In frontend development, state represents the current condition or values of variables. It’s crucial because effective state management enhances the predictability, maintainability, and scalability of the application, ensuring a smooth and responsive user experience.

**Q2: What are the different methods to manage state in React mentioned in the content?**  
**A2:** The methods are:  
1. **Local Component State**: Using the `useState` hook for component-specific data.  
2. **Context API**: For managing global state accessible across components without prop drilling.  
3. **State Management Libraries (e.g., Redux, Recoil)**: Offering advanced features like actions, reducers, and centralized stores for complex global state.  
4. **Recoil**: A library introducing atoms and selectors for flexible and scalable state management in React.

---

### **Problem with Context API**

**Q3: What is the main performance issue with the Context API in React?**  
**A3:** The main issue is that updates to the context can trigger re-renders of all components consuming that context, even if the specific data they need hasn’t changed. This can lead to unnecessary re-renders and impact the application’s performance.

**Q4: How can developers mitigate the re-rendering issue with the Context API?**  
**A4:** Developers can use memoization techniques, such as `useMemo` or `React.memo`, to prevent unnecessary re-renders of components that don’t depend on the changed context data. Alternatively, libraries like Redux, Recoil, or Zustand offer more fine-grained control over state updates and re-renders.

---

### **Recoil**

**Q5: What is Recoil, and how does it improve state management in React?**  
**A5:** Recoil is a state management library developed by Facebook for React applications. It introduces atoms, selectors, and a global state tree, providing a sophisticated, scalable, and organized approach to handling state. It overcomes challenges like prop drilling and the Context API’s re-rendering issues, enhancing efficiency and maintainability.

---

### **Concepts in Recoil**

**Q6: What is the purpose of `RecoilRoot` in a Recoil application?**  
**A6:** `RecoilRoot` is a component that serves as the root of the Recoil state tree. It must be placed at the top level of the React component tree to enable the use of Recoil atoms and selectors throughout the application, providing the necessary context for state management.

**Q7: What is an atom in Recoil, and how is it defined?**  
**A7:** An atom is a unit of state in Recoil that components can read from and write to, acting as a shared piece of state across the component tree. It’s defined using the `atom` function with a unique `key` and a `default` value. Example:  
```jsx
export const countState = atom({
  key: 'countState',
  default: 0,
});
```

**Q8: What are selectors in Recoil, and what is their role?**  
**A8:** Selectors are functions in Recoil that derive new state from existing atoms or other selectors. Their role is to compute derived state based on current state values, enabling complex state logic management. They are created with the `selector` function and accessed with hooks like `useRecoilValue`.

---

### **Recoil Hooks**

**Q9: What does the `useRecoilState` hook do, and how is it used?**  
**A9:** The `useRecoilState` hook returns a tuple with the current value of a Recoil state and a function to update it. It’s used when a component needs both to read and write to an atom. Example:  
```jsx
const [count, setCount] = useRecoilState(countState);
```

**Q10: What is the purpose of the `useRecoilValue` hook?**  
**A10:** The `useRecoilValue` hook retrieves and subscribes to the current value of a Recoil state (atom or selector) without providing a setter function. It’s used when a component only needs to read the state. Example:  
```jsx
const count = useRecoilValue(countState);
```

**Q11: How does the `useSetRecoilState` hook differ from `useRecoilState`?**  
**A11:** The `useSetRecoilState` hook returns a function to set the value of a Recoil state without subscribing to its updates, unlike `useRecoilState`, which provides both the value and a setter. It’s used when a component only needs to update the state. Example:  
```jsx
const setCount = useSetRecoilState(countState);
```

---

### **Selectors**

**Q12: How do you create and use a selector in Recoil?**  
**A12:** A selector is created using the `selector` function, specifying a unique `key` and a `get` function to compute derived state. It’s used in components with `useRecoilValue`. Example:  
```jsx
const doubledCountSelector = selector({
  key: 'doubledCount',
  get: ({ get }) => {
    const count = get(countState);
    return count * 2;
  },
});
const DoubledCountComponent = () => {
  const doubledCount = useRecoilValue(doubledCountSelector);
  return <div>Doubled Count: {doubledCount}</div>;
};
```

**Q13: Can selectors depend on other selectors? Provide an example.**  
**A13:** Yes, selectors can depend on atoms or other selectors for composition. Example:  
```jsx
const totalSelector = selector({
  key: 'total',
  get: ({ get }) => {
    const count = get(countState);
    const doubledCount = get(doubledCountSelector);
    return count + doubledCount;
  },
});
```

---

### **Recoil Code Implementation**

**Q14: What is the first step to set up Recoil in a React project?**  
**A14:** The first step is to install Recoil in the project by running:  
```bash
npm install recoil
```

**Q15: How is `RecoilRoot` implemented in the `App.js` file according to the content?**  
**A15:** `RecoilRoot` is implemented by wrapping the main application component in `App.js`. Example:  
```jsx
import React from 'react';
import { RecoilRoot } from 'recoil';
import Counter from './components/Counter';

function App() {
  return (
    <RecoilRoot>
      <Counter />
    </RecoilRoot>
  );
}

export default App;
```

**Q16: Provide an example of an atom definition from the Recoil code implementation.**  
**A16:** Example:  
```jsx
import { atom } from 'recoil';

export const countState = atom({
  key: 'countState',
  default: 0,
});
```

**Q17: How is the `Counter` component implemented to use Recoil hooks in the provided code?**  
**A17:** The `Counter` component uses `useRecoilState` to read and update `countState` and `useRecoilValue` to check if the count is even. Example:  
```jsx
import React from 'react';
import { useRecoilState, useRecoilValue } from 'recoil';
import { countState } from '../store/atoms/countState';

const Counter = () => {
  const [count, setCount] = useRecoilState(countState);

  const handleIncrease = () => {
    setCount(count + 1);
  };

  const handleDecrease = () => {
    setCount(count - 1);
  };

  const isEven = useRecoilValue(countIsEven);

  return (
    <div>
      <h1>Count: {count}</h1>
      <button onClick={handleIncrease}>Increase</button>
      <button onClick={handleDecrease}>Decrease</button>
      {isEven && <p>It is EVEN</p>}
    </div>
  );
};

export default Counter;
```

---

These questions and answers encapsulate the essential knowledge from "Week 7.2: Context API & Recoil," focusing on state management concepts, the limitations of Context API, and the detailed workings of Recoil, including its core components and practical implementation. Note that the `countIsEven` selector referenced in the `Counter` component is not explicitly defined in the provided content, but it’s implied as a selector checking if the count is even, which is a common use case in Recoil examples.

Below is a set of questions and answers derived directly from the content you provided for "Week 9.1: Custom Hooks." These focus on the key concepts of custom hooks in React, their significance, and practical implementations, ensuring a comprehensive understanding of the material.

---

### **A Few Concepts Before We Begin**

**Q1: What is the ternary operator, and how does it work in JavaScript?**  
**A1:** The ternary operator is a concise way to write an `if-else` statement in one line, with the syntax `condition ? expressionIfTrue : expressionIfFalse`. If the `condition` is `true`, the expression before the colon (`:`) is executed; otherwise, the expression after the colon is executed. Example:  
```jsx
const isRaining = true;
const weatherMessage = isRaining ? "Bring an umbrella" : "Enjoy the sunshine";
console.log(weatherMessage); // Outputs: "Bring an umbrella"
```

**Q2: What are the key lifecycle events in a class-based React component?**  
**A2:** The key lifecycle events are:  
1. **`componentDidMount`**: Called after the component is rendered to the DOM, used for initial setup or data fetching.  
2. **`componentDidUpdate`**: Invoked after an update, useful for reacting to prop or state changes.  
3. **`componentWillUnmount`**: Called before the component is removed from the DOM, suitable for cleanup tasks like removing event listeners.

**Q3: How does the `useEffect` hook simulate lifecycle events in functional components?**  
**A3:** The `useEffect` hook simulates lifecycle events as follows:  
1. **With an empty dependency array (`[]`)**: Runs after the initial render, equivalent to `componentDidMount`.  
2. **With dependencies**: Runs when specified dependencies change, equivalent to `componentDidUpdate`.  
3. **With a cleanup function**: The returned function runs before unmounting, equivalent to `componentWillUnmount`. Example:  
```jsx
useEffect(() => {
  console.log("Mounted");
  return () => console.log("Unmounted");
}, []);
```

**Q4: What is debouncing, and how is it implemented in the `onInput` event example?**  
**A4:** Debouncing is a practice to delay the execution of time-consuming tasks until after a user stops an action (e.g., typing) for a specific duration, improving efficiency. In the `onInput` event example:  
- A `debounce` function takes a function (`func`) and delay (`delay`), using `setTimeout` to execute `func` after `delay`.  
- It clears previous timeouts if the event fires again within the delay. Example:  
```html
<input id="textInput" type="text" onInput="debounce(handleInput, 500)">
<script>
  function debounce(func, delay) {
    let timeoutId;
    return function() {
      clearTimeout(timeoutId);
      timeoutId = setTimeout(() => func.apply(this, arguments), delay);
    };
  }
  function handleInput() {
    const inputValue = document.getElementById("textInput").value;
    document.getElementById("displayText").innerText = "You typed: " + inputValue;
    console.log("Request sent:", inputValue);
  }
</script>
```

---

### **Class Components vs Functional Components**

**Q5: How is state managed in a class-based counter component?**  
**A5:** In a class-based component:  
- State is initialized in the constructor with `this.state = { count: 0 }`.  
- The `setState` method updates the state (e.g., `this.setState({ count: this.state.count + 1 })`). Example:  
```jsx
class MyComponent extends React.Component {
  constructor(props) {
    super(props);
    this.state = { count: 0 };
  }
  incrementCount = () => {
    this.setState({ count: this.state.count + 1 });
  }
  render() {
    return (
      <div>
        <p>{this.state.count}</p>
        <button onClick={this.incrementCount}>Increment</button>
      </div>
    );
  }
}
```

**Q6: How is state managed in a functional counter component?**  
**A6:** In a functional component:  
- The `useState` hook declares state with `const [count, setCount] = useState(0)`.  
- The `setCount` function updates the state (e.g., `setCount(count + 1)`). Example:  
```jsx
function MyComponent() {
  const [count, setCount] = useState(0);
  const incrementCount = () => setCount(count + 1);
  return (
    <div>
      <p>{count}</p>
      <button onClick={incrementCount}>Increment</button>
    </div>
  );
}
```

**Q7: How are lifecycle events handled in a class component vs a functional component?**  
**A7:**  
- **Class Component**: Uses `componentDidMount` for setup, `componentWillUnmount` for cleanup, and `render` for UI. Example:  
```jsx
class MyComponent extends React.Component {
  componentDidMount() { console.log('Component is mounted'); }
  componentWillUnmount() { console.log('Component is about to be unmounted'); }
  render() { return <div>Component Lifecycle Events (Class-Based)</div>; }
}
```
- **Functional Component**: Uses `useEffect` with an empty array for mount/unmount behavior. Example:  
```jsx
function MyComponent() {
  useEffect(() => {
    console.log('Component is mounted');
    return () => console.log('Component is about to be unmounted');
  }, []);
  return <div>Component Lifecycle Events (Functional)</div>;
}
```

---

### **Significance of Returning a Component from useEffect**

**Q8: Why is returning a cleanup function from `useEffect` significant in the provided example?**  
**A8:** Returning a cleanup function from `useEffect` is crucial for managing resources (e.g., intervals) to prevent memory leaks. In the example:  
- `setInterval` toggles the `render` state every 5 seconds.  
- The cleanup function `clearInterval(intervalId)` stops the interval when the component unmounts. Example:  
```jsx
useEffect(() => {
  const intervalId = setInterval(() => setRender(r => !r), 5000);
  return () => clearInterval(intervalId);
}, []);
```

---

### **Custom Hooks**

**Q9: What are custom hooks in React, and why are they used?**  
**A9:** Custom hooks are user-defined functions that encapsulate reusable logic and stateful behavior in React. They are used to avoid code duplication, create a clean separation of concerns, and promote code reusability, making the codebase more maintainable, testable, and scalable.

**Q10: How do custom hooks solve the problem of sharing logic between components?**  
**A10:** Custom hooks encapsulate complex behavior in a single function, allowing it to be reused across components without relying on higher-order components or render props. This isolates functionality, making it easier to reason about and share.

---

### **Use Cases of Custom Hooks**

#### **Data Fetching Hooks**

**Q11: How does the initial `useTodos` custom hook fetch data?**  
**A11:** The initial `useTodos` hook:  
- Uses `useState` to manage `todos`.  
- Uses `useEffect` with an empty array to fetch data from `https://sum-server.100xdevs.com/todos` via Axios on mount.  
- Returns the `todos` state. Example:  
```jsx
function useTodos() {
  const [todos, setTodos] = useState([]);
  useEffect(() => {
    axios.get("https://sum-server.100xdevs.com/todos")
      .then(res => setTodos(res.data.todos));
  }, []);
  return todos;
}
```

**Q12: How does adding a `loading` parameter enhance the `useTodos` hook?**  
**A12:** Adding a `loading` parameter:  
- Introduces `const [loading, setLoading] = useState(true)` to track fetching status.  
- Sets `loading` to `false` after fetching succeeds or fails.  
- Returns an object `{ todos, loading }`, allowing the component to show a loading state. Example:  
```jsx
function useTodos() {
  const [loading, setLoading] = useState(true);
  const [todos, setTodos] = useState([]);
  useEffect(() => {
    axios.get("https://sum-server.100xdevs.com/todos")
      .then(res => {
        setTodos(res.data.todos);
        setLoading(false);
      })
      .catch(() => setLoading(false));
  }, []);
  return { todos, loading };
}
```

**Q13: How does the `useTodos` hook implement auto-refreshing with an interval?**  
**A13:** The `useTodos` hook with auto-refresh:  
- Accepts an `n` parameter for the interval in seconds.  
- Uses `setInterval` to call `getData` every `n * 1000` milliseconds.  
- Cleans up with `clearInterval` on unmount or `n` change. Example:  
```jsx
function useTodos(n) {
  const [loading, setLoading] = useState(true);
  const [todos, setTodos] = useState([]);
  function getData() {
    axios.get("https://sum-server.100xdevs.com/todos")
      .then(res => {
        setTodos(res.data.todos);
        setLoading(false);
      })
      .catch(() => setLoading(false));
  }
  useEffect(() => {
    getData();
    const intervalId = setInterval(getData, n * 1000);
    return () => clearInterval(intervalId);
  }, [n]);
  return { todos, loading };
}
```

**Q14: What does the SWR library’s `useSWR` hook provide in the `Profile` component example?**  
**A14:** The `useSWR` hook:  
- Fetches data from `https://sum-server.100xdevs.com/todos` using a `fetcher` function.  
- Returns `{ data, error, isLoading }` for handling loading, error, and success states. Example:  
```jsx
const fetcher = async (url) => (await fetch(url)).json();
function Profile() {
  const { data, error, isLoading } = useSWR('https://sum-server.100xdevs.com/todos', fetcher);
  if (error) return <div>Failed to load</div>;
  if (isLoading) return <div>Loading...</div>;
  return <div>Hello, you have {data.todos.length} todos!</div>;
}
```

#### **Browser Functionality Related Hooks**

**Q15: How does the `useIsOnline` hook determine online status?**  
**A15:** The `useIsOnline` hook:  
- Initializes `isOnline` with `window.navigator.onLine`.  
- Adds `online` and `offline` event listeners to update `isOnline`.  
- Cleans up listeners on unmount. Example:  
```jsx
function useIsOnline() {
  const [isOnline, setIsOnline] = useState(window.navigator.onLine);
  useEffect(() => {
    const handleOnline = () => setIsOnline(true);
    const handleOffline = () => setIsOnline(false);
    window.addEventListener('online', handleOnline);
    window.addEventListener('offline', handleOffline);
    return () => {
      window.removeEventListener('online', handleOnline);
      window.removeEventListener('offline', handleOffline);
    };
  }, []);
  return isOnline;
}
```

**Q16: How does the `useMousePointer` hook track mouse position?**  
**A16:** The `useMousePointer` hook:  
- Initializes `position` with `{ x: 0, y: 0 }`.  
- Adds a `mousemove` listener to update `position` with `e.clientX` and `e.clientY`.  
- Cleans up the listener on unmount. Example:  
```jsx
const useMousePointer = () => {
  const [position, setPosition] = useState({ x: 0, y: 0 });
  const handleMouseMove = (e) => setPosition({ x: e.clientX, y: e.clientY });
  useEffect(() => {
    window.addEventListener('mousemove', handleMouseMove);
    return () => window.removeEventListener('mousemove', handleMouseMove);
  }, []);
  return position;
};
```

#### **Performance/Timer Based**

**Q17: How does the `useInterval` hook work in the timer example?**  
**A17:** The `useInterval` hook:  
- Takes a `callback` and `delay`, setting an interval with `setInterval(callback, delay)`.  
- Cleans up with `clearInterval` on unmount. Example:  
```jsx
const useInterval = (callback, delay) => {
  useEffect(() => {
    const intervalId = setInterval(callback, delay);
    return () => clearInterval(intervalId);
  }, [callback, delay]);
};
function App() {
  const [count, setCount] = useState(0);
  useInterval(() => setCount(c => c + 1), 1000);
  return <>Timer is at {count}</>;
}
```

**Q18: How does the `useDebounce` hook debounce user input in the `SearchBar` component?**  
**A18:** The `useDebounce` hook:  
- Takes `value` and `delay`, setting a `debouncedValue` after `delay` via `setTimeout`.  
- Clears the timer if `value` changes before `delay`. Example:  
```jsx
const useDebounce = (value, delay) => {
  const [debouncedValue, setDebouncedValue] = useState(value);
  useEffect(() => {
    const timerId = setTimeout(() => setDebouncedValue(value), delay);
    return () => clearTimeout(timerId);
  }, [value, delay]);
  return debouncedValue;
};
const SearchBar = () => {
  const [inputValue, setInputValue] = useState('');
  const debouncedValue = useDebounce(inputValue, 500);
  return (
    <input
      type="text"
      value={inputValue}
      onChange={(e) => setInputValue(e.target.value)}
      placeholder="Search..."
    />
  );
};
```

---
