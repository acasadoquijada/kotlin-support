
// Generated by Akka gRPC. DO NOT EDIT.
package com.example.shoppingcart;

import akka.grpc.GrpcClientSettings;
import akka.grpc.internal.ClientState;
import akka.grpc.internal.JavaUnaryRequestBuilder;
import akka.grpc.internal.NettyClientUtils;
import akka.grpc.internal.ProtoMarshaller;
import akka.grpc.javadsl.AkkaGrpcClient;
import akka.grpc.javadsl.SingleResponseRequestBuilder;
import akka.stream.ActorMaterializer;
import akka.stream.Materializer;
import io.grpc.ManagedChannel;
import io.grpc.MethodDescriptor;
import scala.concurrent.ExecutionContext;

import static com.example.shoppingcart.ShoppingCart.Serializers.*;


public abstract class ShoppingCartClient extends ShoppingCartClientPowerApi implements ShoppingCart, AkkaGrpcClient {
  public static final ShoppingCartClient create(GrpcClientSettings settings, Materializer mat, ExecutionContext ec) {
    return new DefaultShoppingCartClient(settings, mat, ec);
  }

  protected final static class DefaultShoppingCartClient extends ShoppingCartClient {

      private final ClientState clientState;
      private final GrpcClientSettings settings;
      private final io.grpc.CallOptions options;
      private final Materializer mat;
      private final ExecutionContext ec;

      private DefaultShoppingCartClient(GrpcClientSettings settings, Materializer mat, ExecutionContext ec) {
        this.settings = settings;
        this.mat = mat;
        this.ec = ec;
        this.clientState = new ClientState(settings, mat, ec);
        this.options = NettyClientUtils.callOptions(settings);

        if (mat instanceof ActorMaterializer) {
          ((ActorMaterializer) mat).system().getWhenTerminated().whenComplete((v, e) -> close());
        }
      }

  
    
      private final SingleResponseRequestBuilder<ShoppingCartProto.AddLineItem, com.google.protobuf.Empty> addItemRequestBuilder(scala.concurrent.Future<ManagedChannel> channel){
        return new JavaUnaryRequestBuilder<>(addItemDescriptor, channel, options, settings, ec);
      }



      private final SingleResponseRequestBuilder<ShoppingCartProto.RemoveLineItem, com.google.protobuf.Empty> removeItemRequestBuilder(scala.concurrent.Future<ManagedChannel> channel){
        return new JavaUnaryRequestBuilder<>(removeItemDescriptor, channel, options, settings, ec);
      }



      private final SingleResponseRequestBuilder<ShoppingCartProto.GetShoppingCart, ShoppingCartProto.Cart> getCartRequestBuilder(scala.concurrent.Future<ManagedChannel> channel){
        return new JavaUnaryRequestBuilder<>(getCartDescriptor, channel, options, settings, ec);
      }





        /**
         * For access to method metadata use the parameterless version of addItem
         */
        public java.util.concurrent.CompletionStage<com.google.protobuf.Empty> addItem(ShoppingCartProto.AddLineItem request) {
          return addItem().invoke(request);
        }

        /**
         * Lower level "lifted" version of the method, giving access to request metadata etc.
         * prefer addItem(com.example.shoppingcart.ShoppingCartProto.AddLineItem) if possible.
         */

          public SingleResponseRequestBuilder<ShoppingCartProto.AddLineItem, com.google.protobuf.Empty> addItem()

        {
          return clientState.withChannel( this::addItemRequestBuilder);
        }


        /**
         * For access to method metadata use the parameterless version of removeItem
         */
        public java.util.concurrent.CompletionStage<com.google.protobuf.Empty> removeItem(ShoppingCartProto.RemoveLineItem request) {
          return removeItem().invoke(request);
        }

        /**
         * Lower level "lifted" version of the method, giving access to request metadata etc.
         * prefer removeItem(com.example.shoppingcart.ShoppingCartProto.RemoveLineItem) if possible.
         */

          public SingleResponseRequestBuilder<ShoppingCartProto.RemoveLineItem, com.google.protobuf.Empty> removeItem()

        {
          return clientState.withChannel( this::removeItemRequestBuilder);
        }


        /**
         * For access to method metadata use the parameterless version of getCart
         */
        public java.util.concurrent.CompletionStage<ShoppingCartProto.Cart> getCart(ShoppingCartProto.GetShoppingCart request) {
          return getCart().invoke(request);
        }

        /**
         * Lower level "lifted" version of the method, giving access to request metadata etc.
         * prefer getCart(com.example.shoppingcart.ShoppingCartProto.GetShoppingCart) if possible.
         */

          public SingleResponseRequestBuilder<ShoppingCartProto.GetShoppingCart, ShoppingCartProto.Cart> getCart()

        {
          return clientState.withChannel( this::getCartRequestBuilder);
        }



        private static MethodDescriptor<ShoppingCartProto.AddLineItem, com.google.protobuf.Empty> addItemDescriptor =
          MethodDescriptor.<ShoppingCartProto.AddLineItem, com.google.protobuf.Empty>newBuilder()
            .setType(
   MethodDescriptor.MethodType.UNARY



)
            .setFullMethodName(MethodDescriptor.generateFullMethodName("com.example.shoppingcart.ShoppingCart", "AddItem"))
            .setRequestMarshaller(new ProtoMarshaller<ShoppingCartProto.AddLineItem>(AddLineItemSerializer))
            .setResponseMarshaller(new ProtoMarshaller<com.google.protobuf.Empty>(EmptySerializer))
            .setSampledToLocalTracing(true)
            .build();

        private static MethodDescriptor<ShoppingCartProto.RemoveLineItem, com.google.protobuf.Empty> removeItemDescriptor =
          MethodDescriptor.<ShoppingCartProto.RemoveLineItem, com.google.protobuf.Empty>newBuilder()
            .setType(
   MethodDescriptor.MethodType.UNARY



)
            .setFullMethodName(MethodDescriptor.generateFullMethodName("com.example.shoppingcart.ShoppingCart", "RemoveItem"))
            .setRequestMarshaller(new ProtoMarshaller<ShoppingCartProto.RemoveLineItem>(RemoveLineItemSerializer))
            .setResponseMarshaller(new ProtoMarshaller<com.google.protobuf.Empty>(EmptySerializer))
            .setSampledToLocalTracing(true)
            .build();

        private static MethodDescriptor<ShoppingCartProto.GetShoppingCart, ShoppingCartProto.Cart> getCartDescriptor =
          MethodDescriptor.<ShoppingCartProto.GetShoppingCart, ShoppingCartProto.Cart>newBuilder()
            .setType(
   MethodDescriptor.MethodType.UNARY



)
            .setFullMethodName(MethodDescriptor.generateFullMethodName("com.example.shoppingcart.ShoppingCart", "GetCart"))
            .setRequestMarshaller(new ProtoMarshaller<ShoppingCartProto.GetShoppingCart>(GetShoppingCartSerializer))
            .setResponseMarshaller(new ProtoMarshaller<ShoppingCartProto.Cart>(CartSerializer))
            .setSampledToLocalTracing(true)
            .build();
        

      /**
       * Initiates a shutdown in which preexisting and new calls are cancelled.
       */
      public java.util.concurrent.CompletionStage<akka.Done> close() {
        return clientState.closeCS() ;
      }

     /**
      * Returns a CompletionState that completes successfully when shutdown via close()
      * or exceptionally if a connection can not be established after maxConnectionAttempts.
      */
      public java.util.concurrent.CompletionStage<akka.Done> closed() {
        return clientState.closedCS();
      }
  }

}
