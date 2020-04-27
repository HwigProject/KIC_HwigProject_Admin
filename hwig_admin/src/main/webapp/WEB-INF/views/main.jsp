<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/headnav.jsp" %>

        <!--main content start-->
        <section class="main-content-wrapper">
            <div class="pageheader">
                <h1>Dashboard</h1>
                <p class="description">Welcome to NEUBOARD Responsive Admin Theme</p>
                <div class="breadcrumb-wrapper hidden-xs">
                    <span class="label">You are here:</span>
                    <ol class="breadcrumb">
                        <li class="active">Dashboard</li>
                    </ol>
                </div>
            </div>
            <section id="main-content" class="animated fadeInUp">
                <div class="row">
                    <div class="col-md-12 col-lg-6">
                        <div class="row">
                            <div class="col-md-6">
                                <div class="panel panel-solid-success widget-mini">
                                    <div class="panel-body">
                                        <i class="icon-bar-chart"></i>
                                        <span class="total text-center">$3,200</span>
                                        <span class="title text-center">Earnings</span>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="panel widget-mini">
                                    <div class="panel-body">
                                        <i class="icon-support"></i>
                                        <span class="total text-center">1,230</span>
                                        <span class="title text-center">Support</span>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="panel widget-mini">
                                    <div class="panel-body">
                                        <i class="icon-envelope-open"></i>
                                        <span class="total text-center">1,680</span>
                                        <span class="title text-center">Messages</span>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="panel panel-solid-info widget-mini">
                                    <div class="panel-body">
                                        <i class="icon-user"></i>
                                        <span class="total text-center">12,680</span>
                                        <span class="title text-center">Signups</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-xs-12 col-sm-6 col-md-6 col-lg-3">
                        <div class="panel panel-default browser-chart">
                            <div class="panel-heading">
                                <h3 class="panel-title">BROWSER STATS</h3>
                            </div>
                            <div class="panel-body">
                                <div class="row">
                                    <div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
                                        <ul>
                                            <li><i class="fa fa-circle success-color"></i> Chrome</li>
                                            <li><i class="fa fa-circle primary-color"></i> IE</li>
                                            <li><i class="fa fa-circle warning-color"></i> Safari</li>
                                            <li><i class="fa fa-circle info-color"></i> Firefox</li>
                                            <li><i class="fa fa-circle default-color"></i> Other</li>
                                        </ul>
                                    </div>
                                    <div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
                                        <div id="doughnut-canvas-holder">
                                            <canvas id="doughnut-chart-area" width="137" height="137"></canvas>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-xs-12 col-sm-6 col-md-6 col-lg-3">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title">Monthly Goal</h3>
                                <div class="actions pull-right">
                                    <i class="fa fa-expand"></i>
                                </div>
                            </div>
                            <div class="panel-body widget-gauge">
                                <canvas width="160" height="100" id="gauge" class=""></canvas>
                                <div class="goal-wrapper">
                                    <span class="gauge-value pull-left">$</span>
                                    <span id="gauge-text" class="gauge-value pull-left">3,200</span>
                                    <span id="goal-text" class="goal-value pull-right">$5,000</span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12">

                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title">Responsive table</h3>
                                <div class="actions pull-right">
                                    <i class="fa fa-expand"></i>
                                    <i class="fa fa-chevron-down"></i>
                                    <i class="fa fa-times"></i>
                                </div>
                            </div>
                            <div class="panel-body">

                                <div class="table-responsive">
                                    <table class="table table-bordered table-striped">
                                        <thead>
                                            <tr>
                                                <th>#</th>
                                                <th>Table heading</th>
                                                <th>Table heading</th>
                                                <th>Table heading</th>
                                                <th>Table heading</th>
                                                <th>Table heading</th>
                                                <th>Table heading</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td>1</td>
                                                <td>Table cell</td>
                                                <td>Table cell</td>
                                                <td>Table cell</td>
                                                <td>Table cell</td>
                                                <td>Table cell</td>
                                                <td>Table cell</td>
                                            </tr>
                                            <tr>
                                                <td>2</td>
                                                <td>Table cell</td>
                                                <td>Table cell</td>
                                                <td>Table cell</td>
                                                <td>Table cell</td>
                                                <td>Table cell</td>
                                                <td>Table cell</td>
                                            </tr>
                                            <tr>
                                                <td>3</td>
                                                <td>Table cell</td>
                                                <td>Table cell</td>
                                                <td>Table cell</td>
                                                <td>Table cell</td>
                                                <td>Table cell</td>
                                                <td>Table cell</td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>

                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-12 col-sm-12 col-md-6 col-lg-4">
                        <div class="panel">
                            <div class="panel-body">
                                <div class="calendar-block ">
                                    <div class="cal1">

                                    </div>
                                </div>

                            </div>
                        </div>
                    </div>
                    
                    <div class="col-xs-12 col-sm-12 col-md-12 col-lg-8">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title">Contextual classes</h3>
                                <div class="actions pull-right">
                                    <i class="fa fa-expand"></i>
                                    <i class="fa fa-chevron-down"></i>
                                    <i class="fa fa-times"></i>
                                </div>
                            </div>
                            <div class="panel-body">

                                <table class="table">
                                    <thead>
                                        <tr>
                                            <th>#</th>
                                            <th>Column heading</th>
                                            <th>Column heading</th>
                                            <th>Column heading</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr class="active">
                                            <td>1</td>
                                            <td>Column content</td>
                                            <td>Column content</td>
                                            <td>Column content</td>
                                        </tr>
                                        <tr>
                                            <td>2</td>
                                            <td>Column content</td>
                                            <td>Column content</td>
                                            <td>Column content</td>
                                        </tr>
                                        <tr class="success">
                                            <td>3</td>
                                            <td>Column content</td>
                                            <td>Column content</td>
                                            <td>Column content</td>
                                        </tr>
                                        <tr class="info">
                                            <td>4</td>
                                            <td>Column content</td>
                                            <td>Column content</td>
                                            <td>Column content</td>
                                        </tr>
                                        <tr class="warning">
                                            <td>5</td>
                                            <td>Column content</td>
                                            <td>Column content</td>
                                            <td>Column content</td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </section>
        <!--main content end-->
    
<%@ include file="/WEB-INF/views/include/footnav.jsp" %>