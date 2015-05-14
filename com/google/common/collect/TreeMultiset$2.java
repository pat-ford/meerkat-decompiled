package com.google.common.collect;

import java.util.Iterator;
import java.util.NoSuchElementException;

class TreeMultiset$2
  implements Iterator<Multiset.Entry<E>>
{
  TreeMultiset.AvlNode<E> current = TreeMultiset.access$1200(this.this$0);
  Multiset.Entry<E> prevEntry;

  TreeMultiset$2(TreeMultiset paramTreeMultiset)
  {
  }

  public boolean hasNext()
  {
    if (this.current == null)
      return false;
    if (TreeMultiset.access$1300(this.this$0).tooHigh(this.current.getElement()))
    {
      this.current = null;
      return false;
    }
    return true;
  }

  public Multiset.Entry<E> next()
  {
    if (!hasNext())
      throw new NoSuchElementException();
    Multiset.Entry localEntry = TreeMultiset.access$1400(this.this$0, this.current);
    this.prevEntry = localEntry;
    if (TreeMultiset.AvlNode.access$900(this.current) == TreeMultiset.access$1500(this.this$0))
    {
      this.current = null;
      return localEntry;
    }
    this.current = TreeMultiset.AvlNode.access$900(this.current);
    return localEntry;
  }

  public void remove()
  {
    if (this.prevEntry != null);
    for (boolean bool = true; ; bool = false)
    {
      CollectPreconditions.checkRemove(bool);
      this.this$0.setCount(this.prevEntry.getElement(), 0);
      this.prevEntry = null;
      return;
    }
  }
}