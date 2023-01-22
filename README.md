<div _ngcontent-bwj-c194="" id="programming-exercise-instructions-content" class="guided-tour instructions__content__markdown markdown-preview"><h3 id="trees">Trees.</h3>
<p>Trees are, besides lists, stacks and queues, another flexible data-structure with many applications.
In general, a tree consists of nodes which may hava multiple successors.
The topmost node which has no further predecessor is also called root node. The bottom nodes without successors are the
leaves. All other nodes are called internal.
Data are only stored in non-leaf nodes.</p>
<p>In this assignment a particular kind of trees is implemented, namely, sorted binary trees.
Binary trees are trees where each node either has two successors (<code>left</code> and <code>right</code>), or none.
Sorted means that at each node, the invariant holds that all elements stored in the left subtree
are less or equal to the element in the node, which in turn is less or equal to all elements in the right subtree.
Moreover, we want arbitrarily many elements to be stored inside the tree.</p>
<p>For the realization, we use the Composite pattern. In contrast to lists, we represent the empty data-structure not by means of
<code>null</code> but by an object of the class <code>Leaf</code>.
Consider the following UML diagram:</p>
<p><img alt="composite.png" src="/api/files/markdown/Markdown_2022-11-16T18-03-37-578_2dafff76.png"></p>
<p>The constructor of a tree should receive as parameter a
<a rel="noopener noreferrer" href="https://docs.oracle.com/javase/7/docs/api/java/util/Comparator.html">comparator</a>
which determines the ordering of the elements.
Initiall, <code>root</code> should be initialized as <code>Leaf</code>.
The constructor of class <code>InnerNode</code> receives <code>info</code> as parameter, while <code>left</code> and <code>right</code> are initialized
as <code>Leaf</code> objects.</p>
<p>When implementing any method, take care to exploit sortedness and inspec only those parts of the tree which are
really necessary.
The method <code>contains</code>, e.g., may not visit nodes which are excluded due to sortedness.</p>
