/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author Natalia
 */
public class BaseView {
    protected IControllerForView controllerForView = ControllerForView.getInstance();
    protected CommunicationController commController = CommunicationController.getInstance();
}
