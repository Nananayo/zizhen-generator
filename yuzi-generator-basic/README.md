用到了freemarker可以把模板文件的部分内容动态替换
yuzi-generator-basic/src/main/java/com/yupi/generator
DynamicGenerator：动态文件生成
MainGenerator：调用动态文件生成和静态文件生成生成全部文件，并设置参数
StaticGenerator：静态文件生成
MainTemplateConfig：模板配置

src/main/java/com/yupi/cli
example：主要是封装了命令行参数，以及命令行参数的解析。
ASCIIArt：主要是命令行的传参操作，picocli可以把用户在命令行输入的参数保存在对象中，方便后续使用。
Login：interactive = true参数可以让用户在命令行中输入参数，而不需要通过命令行参数。
SubCommandExample：子命令，可以嵌套使用，这里主要是将子命令绑定到该命令上。
picocli：必须实现Runnable或者Callable<type>接口，最外边实现的是主命令，可以为主命令添加一些命令（子命令）
子命令可以嵌套使用（即add参数之后可以有类似于 add name 或者 add age的命令）

pattern：主要是解释命令模式
command：“命令”，一个接口，实现这个接口来创建一个命令，同时也必须要有execute（“执行”）方法，即创建调用者
Device：“装置”，一个实现类，可以创建一个被命令者，包含两个被命令者的操作 即turnOn和turnOff打开与关闭
RemoteControl：“远程控制”，创建了一个私有的command 即可以将命令绑定给一个RemoteControl，使其可以操作Device
TurnOffCommand：实现了command接口，即一个命令，包括execute（）方法，即调用者 实现了Device可以通过这个命令来调用Device的turnOn
TurnOnCommand：实现了command接口，即一个命令，包括execute（）方法，即调用者实现了Device可以通过这个命令来调用Device的turnOff
Client：创建两个Device实例 将TurnOnCommand和TurnOffCommand分别绑定到两个Device实例上，对应两个操作，创建RemoteControl实例，并将TurnOnCommand和TurnOffCommand给RemoteControl实例，即使其可以操作这两个Device


CommandExecutor:用来绑定所有子命令，这里即为ConfigCommand和GenerateCommand和ListCommand三个类的子命令
ConfigCommand:可以使用config参数获取参数信息
GenerateCommand：可以使用generate -l -o -a 传入参数并获取生成代码
ListCommand：可以使用list参数获取所生成文件的路径信息
外边的main：创建CommandExecutor实例，并将执行命令