package com.herosandwich.events;


import com.herosandwich.events.*;
import java.util.ArrayList;
import java.util.HashMap;

/** Notifies subscribed listeners when particular event class occurs **/
/** This class is a singleton **/
public final class EventDispatcher {
    /** Map events to listeners **/
    private final HashMap<Class, ArrayList> map = new HashMap<Class, ArrayList>();

    /** instantiate the single instance **/
    private static EventDispatcher eventDispatcher = new EventDispatcher();

    /** private constructor for singleton implementation **/
    private EventDispatcher() { }

    /** return the single instance **/
    public static EventDispatcher getInstance() {
        return eventDispatcher;
    }

    /** Subscribe a listener to an event class **/
    public <T> void subscribe( Class eventClass, T listener ) {
        final ArrayList<T> listeners = getListeners(eventClass);
        synchronized (listeners) {
            if (!listeners.contains(listener)) {
                listeners.add(listener);
            }
        }
    }

    /** Unsubscribe a listener from an event class **/
    public <T> void unsubscribe( Class<? extends GameEvent<T>> eventClass, T listener) {
        final ArrayList<T> listeners = getListeners( eventClass );
        synchronized( listeners ) {
            listeners.remove( listener );
        }
    }

    /** Gets Listeners for a given event class **/
    private <T> ArrayList<T> getListeners(Class<? extends GameEvent<T>> eventClass) {
        synchronized ( map ) {
            final ArrayList<T> existing = map.get( eventClass );
            if (existing != null) {
                return existing;
            }

            final ArrayList<T> emptyList = new ArrayList<T>();
            map.put(eventClass, emptyList);
            return emptyList;
        }
    }


    /** Notify subscribed listeners an event has occurred **/
    public <T> void notify( final GameEvent<T> event) {
        Class<GameEvent<T>> eventClass = (Class<GameEvent<T>>) event.getClass();

        for ( T listener : getListeners(  eventClass ) ) {
            event.notify(listener);
        }
    }

}

