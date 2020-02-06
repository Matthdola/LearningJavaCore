/* Stacks! */
function isWordPalindrome(){
    // funtions: push, pop, peek, length
    var letters = []; // this is our stack

    var word = "racecar";

    var rword = "";

    // put letters of word into stack
    for (let i = 0; i < word.length; i++) {
        letters.push(word[i]);
    }

    // pop off the stack in reverse order
    for (let i = 0; i < word.length; i++) {
        rword += letters.pop();
    }

    if(rword === word) {
        console.log(word + " is a palindrome.");
    } else {
        console.log(word + " is not a palindrome.");
    }
}

var Stack = function() {
    this.count = 0;
    this.storage = {};

    //Adds a value onto the end of the stack
    this.push = function(value) {
        this.storage[this.count] = value;
        this.count++;
    }

    // Remove and returns the value at the end of the stack
    this.pop = function() {
        if(this.count === 0) {
            return undefined;
        }

        this.count--;
        var result = this.storage[this.count];
        delete this.storage[this.count];
        return result;
    }

    // Returhnthe value at the end of the stack
    this.peek = function() {
        return this.storage[this.count-1];
    }

    this.size = function(){
        return this.count;
    }
}

var testStack = function() {
    var myStack = new Stack();

    myStack.push(1);
    myStack.push(45);
    console.log(myStack.peek());
    console.log(myStack.pop());
    console.log(myStack.peek());
    myStack.push("freeCodeCamp");
    console.log(myStack.size());
    console.log(myStack.peek())
}

/* Sets */

var Set = function() {
    // the var collection will hold the set
    var collection = [];

    //This method will check for the presence of an element and return true or false
    this.has = function(element) {
        return (collection.indexOf(element) !== -1);
    }

    // this method will return all the values in the set
    this.values = function() {
        return collection;
    }

    // this method will add an element to the set
    this.add = function(element) {
        if(!this.has(element)) {
            collection.push(element)
            return true;
        }
        return false;
    }

    // this method will remove an element from a set
    this.remove = function(element) {
        if (this.has(element)) {
            index = collection.indexOf(element);
            collection.slice(index, 1);
            return true;
        }
        return false;
    }

    // this method will return the size of the collection
    this.size = function() {
        return this.collection.length;
    }

    // this method will return the union of two sets
    this.union = function(otherSet) {
        var unionSet = new Set();
        var firstSet = this.values();
        var secondSet = otherSet.values();
        firstSet.forEach(element => {
            unionSet.add(element);
        });
        secondSet.forEach(element => {
            unionSet.add(element);
        });

        return unionSet;
    }

    // this method will return the intersection of two sets as a new set
    this.intersection = function(otherSet) {
        var intersection = new Set();
        var firstSet = this.values();
        firstSet.forEach(function(e) {
            if(otherSet.has(e)){
                intersection.add(e);
            }
        });
        return intersection;
    }

    // This method will return the difference of two sets as a new set
    this.difference = function(otherSet) {
        var differenceSet = new Set();
        var firstSet = this.values();
        firstSet.forEach(function(e) {
            if(!otherSet.has(e)){
                differenceSet.add(e);
            }
        })
        return differenceSet;
    }

    // this method will test if the set is a subset of a difference set
    this.subset = function (otherSet) {
        var firstSet = this.values();
        return firstSet.every(function (value) {
            return otherSet.has(value);
        });
    }
}

var testSet = function () {
    var setA = new Set();
    var setB = new Set();
    setA.add("a");
    setB.add("a");
    setA.add("b");
    setB.add("b");
    setB.add("c");
    setA.add("c");
    setA.add("d");
    console.log(setA.subset(setB).values());
    console.log(setA.intersection(setB).values());

    var setC = new Set();
    var setD = new Set();
    setC.add("a");
    setD.add("b");
    setD.add("c");
    setD.add("d");
    console.log(setD.values());
    setD.remove("a");
    console.log(setD.has("a"));
}

var Queue = function () {
    var collection = [];

    this.print = function() {
        console.log(collection);
    };

    this.enqueue = function(element) {
        collection.push(element);
    };

    this.dequeue = function() {
        return collection.shift();
    };

    this.front = function() {
        return collection[0];
    };

    this.size = function() {
        return collection.length;
    };

    this.isEmpty = function() {
        reurn (collection.length === 0);
    };
}

var testQueue = function () {
    var q = new Queue();
    q.enqueue("a");
    q.enqueue("b");
    q.enqueue("c");
    q.print();
    q.dequeue();
    console.log(q.front());
    q.print();
}

var PriorityQueue = function() {
    var collection = [];
    this.printCollection = function {
        console.log(collection);
    }

    this.enqueue = function(element) {
        if( this.isEmpty()) {
            collection.push(element);
        } else {
            var added = false;
            for (let i = 0; i < collection.length; i++) {
                if(element[1] < collection[i][1]){
                    //Checking priorities
                    collection.splice(i, 0, element);
                    added = true;
                    break;
                }
                if(!added) {
                    collection.push(element);
                }
            }
        }
    }

    this.dequeue = function() {
        var value = collection.shift();
        return value[0];
    }

    this.front = function() {
        return collection[0];
    }

    this.size = function() {
        return collection.length;
    }

    this.isEmpty = function () {
        return (collection.length === 0);
    }
}

var testPriorityQueue = function() {
    var pq = new PriorityQueue();
    pq.enqueue(['Beau Carnes', 21]);
    pq.enqueue(['Quincy Larson', 3]);
    pq.enqueue(['Ewa Mytulska-Wojcik', 1]);
    pq.printCollection();
    pq.dequeue();
    pq.front();
    pq.printCollection();
}

class Node {
    constructor(data, left=null, right = null) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}

class BST {
    constructor() {
        this.root = null;
    }

    add(data) {
        const node = this.root;
        if(node === null) {
            this.root = new Node(data);
            return;
        } else {
            const searchTree = function(node) {
                if(data < node.data) {
                    if(node.left === null){
                        node.left = new Node(data);
                        return;
                    } else if(node.left !== null) {
                        return searchTree(node.left);
                    }
                } else if(data > node.data) {
                    if(node.right === null) {
                        node.right = new Node(data);
                        return;
                    } else if(node.right !== null) {
                        return searchTree(node.right);
                    }
                } else {
                    return null;
                }
            }
        };
        return searchTree(node);
    }

    findMin() {

    }


    findMax() {

    }

    find(data) {
        
    }
}