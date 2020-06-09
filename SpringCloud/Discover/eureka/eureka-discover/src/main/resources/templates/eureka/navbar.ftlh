<h1>System Status</h1>
<div class="row">
    <div class="col-md-6">
        <table id='instances' class="table table-condensed table-striped table-hover">
            <#if amazonInfo??>
                <tr>
                    <td>EUREKA SERVER</td>
                    <td>AMI: ${amiId!}</td>
                </tr>
                <tr>
                    <td>Zone</td>
                    <td>${availabilityZone!}</td>
                </tr>
                <tr>
                    <td>instance-id</td>
                    <td>${instanceId!}</td>
                </tr>
            </#if>
            <tr>
                <td>Environment</td>
                <td>${environment!}</td>
            </tr>
            <tr>
                <td>Data center</td>
                <td>${datacenter!}</td>
            </tr>
            <tr>
                <td rowspan="3">
                    <iframe src="https://3g.dxy.cn/newh5/view/pneumonia" frameborder="0" width="500px" height="670px" allowtransparency="yes" style="overflow:hidden;margin: 0; border: none;"></iframe>
                <#--<img src="http://07imgmini.eastday.com/mobile/20180913/20180913134501_f3cb0c521accbc0a71d03691ac069e5c_2.jpeg" width="300px"/>-->
                </td>
                <td>
                    <table style="height:670px;">
                        <tr>
                            <td style="vertical-align: middle !important;height: 100px;color: #3CB371;font-size: large;text-align: center;">
                                TS-ADC Micro Service Registration Center (HR CLUSTER)
                            </td>
                        </tr>
                        <tr>
                            <td style="text-align: center;">
                                <label style="vertical-align: middle !important;height: 100px;color: #1E90FF;font-size: medium;">Version: 0.1 RELEASE</label>
                                &nbsp;
                                <label style="vertical-align: middle !important;height: 100px;color: #008080;font-size: small;">Author: KG</label>
                            </td>
                        </tr>
                        <tr>
                            <td style="text-align: center;">
                                <iframe scrolling="no" src="https://tianqiapi.com/api.php?style=tw&skin=pitaya" frameborder="0" width="300" height="400" allowtransparency="true"></iframe>
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>
        </table>
    </div>
    <div class="col-md-6">
        <table id='instances' class="table table-condensed table-striped table-hover">
            <tr>
                <td>Current time</td>
                <td>${currentTime}</td>
            </tr>
            <tr>
                <td>Uptime</td>
                <td>${upTime}</td>
            </tr>
            <tr>
                <td>Lease expiration enabled</td>
                <td>${registry.leaseExpirationEnabled?c}</td>
            </tr>
            <tr>
                <td>Renews threshold</td>
                <td>${registry.numOfRenewsPerMinThreshold}</td>
            </tr>
            <tr>
                <td>Renews (last min)</td>
                <td>${registry.numOfRenewsInLastMin}</td>
            </tr>
        </table>
    </div>
</div>

<#if isBelowRenewThresold>
    <#if !registry.selfPreservationModeEnabled>
        <h4 id="uptime"><font size="+1" color="red"><b>RENEWALS ARE LESSER THAN THE THRESHOLD. THE SELF PRESERVATION
                    MODE IS TURNED OFF. THIS MAY NOT PROTECT INSTANCE EXPIRY IN CASE OF NETWORK/OTHER
                    PROBLEMS.</b></font></h4>
    <#else>
        <h4 id="uptime"><font size="+1" color="red"><b>EMERGENCY! EUREKA MAY BE INCORRECTLY CLAIMING INSTANCES ARE UP
                    WHEN THEY'RE NOT. RENEWALS ARE LESSER THAN THRESHOLD AND HENCE THE INSTANCES ARE NOT BEING EXPIRED
                    JUST TO BE SAFE.</b></font></h4>
    </#if>
<#elseif !registry.selfPreservationModeEnabled>
    <h4 id="uptime"><font size="+1" color="red"><b>THE SELF PRESERVATION MODE IS TURNED OFF. THIS MAY NOT PROTECT
                INSTANCE EXPIRY IN CASE OF NETWORK/OTHER PROBLEMS.</b></font></h4>
</#if>

<h1>DS Replicas</h1>
<ul class="list-group">
    <#list replicas as replica>
        <li class="list-group-item"><a href="${replica.value}">${replica.key}</a></li>
    </#list>
</ul>

