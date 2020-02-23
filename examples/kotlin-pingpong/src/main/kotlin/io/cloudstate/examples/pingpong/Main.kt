package io.cloudstate.examples.pingpong

import io.cloudstate.kotlinsupport.cloudstate

class Main {

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            cloudstate {
                registerEventSourcedEntity {
                    entityService = PingPongEntity::class.java
                    descriptor = Pingpong.getDescriptor().findServiceByName("PingPongService")
                    additionalDescriptors = arrayOf( Pingpong.getDescriptor() )
                }
            }.start()
                    .toCompletableFuture()
                    .get()
        }
    }
}