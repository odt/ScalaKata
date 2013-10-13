abstract class Tree
{
public:

    nothrow pure const Tree insert(in int newValue);
    pure const int [] collect();
}

class EmptyNode : Tree
{
public:

    override nothrow pure const Tree insert(in int value)
    {
        return new Node(empty(), empty(), value);
    }

    override pure const int [] collect()
    {
        return [];
    }

    unittest {
        auto node = new EmptyNode();
        assert(node.collect() == []);
        assert(node.insert(3).collect() == [3]);
    }
}

nothrow pure EmptyNode empty()
{
    return new EmptyNode();
}

class Node : Tree
{
public:

    const Tree left, right;
    int value;

    nothrow this(in Tree left_, in Tree right_, in int value_)
    body
        {
            this.left = left_;
            this.right = right_;
            this.value = value_;
        }

    override nothrow pure const Tree insert(in int newValue)
    {
        if (newValue < value) {
            return new Node(left.insert(newValue), right, value);
        } else {
            return new Node(left, right.insert(newValue), value);
        }
    }

    override const int [] collect()
    {
        return (left.collect() ~ [value] ~ right.collect());
    }

    unittest {
        Tree gen(int i) {
            return empty().insert(i);
        }

        assert(gen(3).collect() == [3]);
        assert((new Node(empty(), gen(5), 3)).collect() == [3, 5]);
        assert((new Node(gen(1), gen(5), 3)).collect() == [1, 3, 5]);
    }
}

class Rack
{
private:
    Tree root;

public:

    this()
    {
        root = empty();
    }

    nothrow void add(in int ball)
    {
        root = root.insert(ball);
    }

    int [] balls()
    {
        return root.collect();
    }
}

unittest {
    auto rack = new Rack();
    assert(rack.balls() == []);
    rack.add(20);
    assert(rack.balls() == [20]);
    rack.add(10);
    assert(rack.balls() == [10, 20]);
    rack.add(30);
    assert(rack.balls() == [10, 20, 30]);
    rack.add(20);
    assert(rack.balls() == [10, 20, 20, 30]);
}

void main() {}
