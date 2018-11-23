/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import org.apache.oozie.fluentjob.api.action.ShellAction;
import org.apache.oozie.fluentjob.api.action.ShellActionBuilder;
import org.apache.oozie.fluentjob.api.factory.WorkflowFactory;
import org.apache.oozie.fluentjob.api.workflow.Workflow;
import org.apache.oozie.fluentjob.api.workflow.WorkflowBuilder;

public class OozieFluentJobApiDemo implements WorkflowFactory {

    public Workflow create() {
        final ShellAction shellAction = ShellActionBuilder.create()
                .withName("shell-action")
                .withResourceManager("${resourceManager}")
                .withNameNode("${nameNode}")
                .withConfigProperty("mapred.job.queue.name", "${queueName}")
                .withExecutable("/bin/echo")
                .withArgument("my_output=Hello Oozie")
                .withCaptureOutput(true)
                .build();

        final Workflow shellWorkflow = new WorkflowBuilder()
                .withName("shell-workflow")
                .withDagContainingNode(shellAction).build();

        return shellWorkflow;
    }

    public static void main(String[] args) {

        new OozieFluentJobApiDemo().create();
    }
}