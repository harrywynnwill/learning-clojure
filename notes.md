### Leiningen

Leiningen used to build and manage projects.

http://leiningen.org/

to generate a Closure project

`$ lein new app clojure-noob`

to run that program `$ lein run`

the `-main` function runs you execute `lein run`.

to share the project with others not using Leiningen you need to create a stand-alone file that anyone with java can run. You can do this using `$ lein uberjar`.

to run this java file can use the command `$ java -jar target/uberjar/clojure-noob-0.1.0-SNAPSHOT-standalone.jar`

`$ lein repl` loads the REPL.

run the main method in the REPL using `(-main)`  

`clojure-noob.core=> (-main)`

adding `(+ 1 2 3 4 5)`

`15`

first in an array `(first[1 2 3 4])`

All Lisps, Clojure included, employ prefix notification. Meaning the operator always comes first.

`(reduce + [5 6 100])`

wrapping and slurping

`(+ 1 2 3 4)` wrapping


`(+ 1 (* 2 3) 4)` slurping moves the parenthesis to include the next expression to the right. the `3` has been slurped to the wrapped `2`.

#### Forms

Clojure recognises two kinds of structures:

1. literal representations of data structures (numbers, strings, maps and vectors)
2. operations

`1` number

`"strting"` string

`["a" "vector" "of" "strings"]` vector

literals are used in operations.

Operatations are how you do things.

all operations take the form of opening parenthesis, operator, operands, closing parenthesis.

`(operator operand1 operand2 operand3)`

There are no commas, clojure uses white space.

`(str "this is " "a" "test")` clojure concatenates on the whitespace.

#### Control Flow

##### `if`

```
(if boolean-form
  then-form
  optional-else-form)
```
```
(if true
  "By Zeus's hammer!"
  "By Aquaman's trident!")
; => "By Zeus's hammer!"
```

You can omit the `else` branch and Clojure will return `nil` if `false`

using the above sytax you can only have one form per branch, to get around this you use `do`.

```
(if true
  (do (println "Success!")
      "By Zeus's hammer!")
  (do (println "Failure!")
      "By Aquaman's trident!"))
; => Success!
; => "By Zeus's hammer!"
```

 `when` operator like a combination of `if` and `do`, but with no `else`

 Use when if you want to multiple things when true and always return nil if false.

##### nil, true, false, Truthiness, Equality, and Boolean Expressions

Clojure has `true` `false` and `nil` values

you can check if a value is `nil` using `(nil?)`

both `nil` and `false` used to represent falsey values everything else is truthy.

`(= )` equality operator.

`or` returns either the first truthy value or the last.

`and` returns the first falsey value, or if no values are falsey the last truthy value.

#### Naming values with defn

You can use `def` to bind a name to a value.

`def` should be treated as a constants. You wont need to change variables if you embrace functional programming.

```
(def failed-protagonist-names
  ["Larry Potter" "Doreen the Explorer" "The Incredible Bulk"])

failed-protagonist-names
; => ["Larry Potter" "Doreen the Explorer" "The Incredible Bulk"]
```

#### Data structures

Clojure comes with a handful of data structures.

All clojures data structures are immutable, meaning you cant change them in place.

`93` integer

`1.2` float

`1/5` ratio

Clojure only allows double quotes to define string literals.

It only allows for string concatenation using the `(str )` form.

##### Maps

Maps are similiar to hashes.

2 types of maps in clojure - ordered and sorted.

`{}` empty map

`(hash-map :a 1 :b 2)` non literal way to declare a map

`(get {:a 0 :b {:c "ho hum"}} :b)` use get to lookup values in the map.

get will return nil if it does not find your key, or you can give it a default value to return.

```
(get {:a 0 :b 1} :c)
; => nil

(get {:a 0 :b 1} :c "unicorns?")
; => "unicorns?"
```

`(get-in)` function lets you look up nested values.


`(get-in {:a 0 :b {:c "ho hum"}} [:b :c])
; => "ho hum"`

another way is to treat the map as a function with the key as arguments

`({:heebs "is gammy" :harry "is dog"} :harry)`

##### Keywords

keywords primarily used as keys in maps.

`:a` keyword.

`(:a {:a 1 :b 2 :c 3})
; => 1` used as a function to look up value in map

##### vectors

a vector is similar to an array, in that its a zero indexed collection.

`[1 2 3 4]`

```
(get [3 2 1] 0)
; => 3
```

uses the same get function as with maps

vector can contain any type

`(conj [0 1 2 3] 4)` to add additional elements to the array

##### Lists

Lists are similiar to vectors in that theyre liniear collections of values.

You cant retrieve a list element with get.

`'(1 2 3 4)` literal list - single quote mark and parentheses.

you can use`nth` to retrieve an element from a list.

`(nth '(1 2 3 4 5) 3)`

This is slower than using get as it has to traverse all n elements to retrieve nth element.

lists can have any type.

##### Sets


sets are collections of unique values. 2 types of sets: hash-sets and sorted sets

literal notation for a hash-set `#`

`#{"kurt" 20 :icicle}`


```
(hash-set 1 2 3 4 5 1 2 3)
#{1 4 3 2 5}
```

you can create sets from existing vectors using `set`

`(set [1 2 2 3 3])`


you can check for set memebership using `contains?`

`(contains? #{:a :b} :b)`

can also use `get`

```
It is better to have 100 functions operate on one data structure than 10 functions on 10 data structures.
—Alan Perlis
```

#### functions

Lisp functions are very simple.

function call is just another term for an operation where the operator is a function or function expression.

valid functions:
`((first [+ 0]) 1 2 3)`

`((or + -) 1 2 3)`

not valid functions:

`(1 2 3 4)`

`("test" 1 2 3)`

functions can take expressions as arguments. functions that either take a function as an arguemnt or return a function are called higher-order functions.

languages with higher order functions are said to support first class functions because you can treat functions as values in the same way you would treat other data types.

`(inc 1.1)` increments the number by 1 => 2.1

`(map inc [1 2 3])` => (2 3 4)

map creates a new list by incrementing each element in the vector by 1.

NB it does not return a vector.

First-class functions allow you to build more powerful abstractions than you can in OO languages.

Clojure (and all lisps) allow you to create functions that generalize over process.

`map` allows you to generalize the process of transforming a function by applying a function over any function.

clojure evaluates all function arguemnts recursively.

`(doc fn-name)` returns a description of the method

```
(defn too-enthusiastic
  "return an array of numbers"
  [number]
  ...
  )
  ```

  "return an array of letters" is the doc string

  Can define a function with 0 or more parameters, values passed to functions are called arguments.

  `[]` no parameters OR 0-arity function

  `[x]` one param OR 1-arity function

  `[x y]` two params OR 2-arity function

  functions can have arity overloading. This means a different function body will run depending on the arity.

  can define a default arguement for the param with the following syntax:

  ```
  (defn x-chop
  "Describe the kind of chop you're inflicting on someone"
  ([name chop-type]
     (str "I " chop-type " chop " name "! Take that!"))
  ([name]
     (x-chop name "karate")))
  ```

` (x-chop name "karate")` <-- here the arguement is set to a default if only one arg given to function call. Defining a function in terms of itself is functional programming. you calll the function with the argument and a param.

You can also make arity do something totally unrelated.

Clojure allows you to define variable-arity functions by including the rest parameter `&` (put the rest of these arguemnts in a list of the following name).

```
(defn codger-communication
  [whippersnapper]
  (str "Get off my lawn, " whippersnapper "!!!"))

(defn codger
  [& whippersnappers]
  (map codger-communication whippersnappers))
```

when you provide arguements to a variable-arity function they are treated as a list.

you can mix variable-arity and normal parameters but the rest param has to come last.


```
(defn favorite-things
  [name & things]
  (str "Hi, " name ", here are my favorite things: "
       (clojure.string/join ", " things)))

(favorite-things "Doreen" "gum" "shoes" "kara-te")
```
