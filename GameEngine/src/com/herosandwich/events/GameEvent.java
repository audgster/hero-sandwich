package com.herosandwich.events;

/** Interface that all events must conform to
 *  The parameter specifies the type of listener this event maps to
 **/
public interface GameEvent<T> {

    public void notify( final T listener );

}