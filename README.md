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
<p>The methods are meant to do the following:</p>
<ul>
<li><div class="pe-task-66 d-flex"><jhi-programming-exercise-instructions-task-status _nghost-bwj-c192="" class="ng-star-inserted"><div _ngcontent-bwj-c192="" class="guided-tour">
    <!---->
    <!---->
    <fa-icon _ngcontent-bwj-c192="" size="lg" class="ng-fa-icon test-icon text-secondary ng-star-inserted"><svg role="img" aria-hidden="true" focusable="false" data-prefix="fas" data-icon="circle-question" class="svg-inline--fa fa-circle-question fa-lg" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512"><path fill="currentColor" d="M256 512c141.4 0 256-114.6 256-256S397.4 0 256 0S0 114.6 0 256S114.6 512 256 512zM169.8 165.3c7.9-22.3 29.1-37.3 52.8-37.3h58.3c34.9 0 63.1 28.3 63.1 63.1c0 22.6-12.1 43.5-31.7 54.8L280 264.4c-.2 13-10.9 23.6-24 23.6c-13.3 0-24-10.7-24-24V250.5c0-8.6 4.6-16.5 12.1-20.8l44.3-25.4c4.7-2.7 7.6-7.7 7.6-13.1c0-8.4-6.8-15.1-15.1-15.1H222.6c-3.4 0-6.4 2.1-7.5 5.3l-.4 1.2c-4.4 12.5-18.2 19-30.6 14.6s-19-18.2-14.6-30.6l.4-1.2zM288 352c0 17.7-14.3 32-32 32s-32-14.3-32-32s14.3-32 32-32s32 14.3 32 32z"></path></svg></fa-icon><!---->
  
